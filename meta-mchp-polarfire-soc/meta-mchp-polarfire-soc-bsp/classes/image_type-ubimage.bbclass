# Copyright (c) 2019-2020, Wifx Sàrl <info@wifx.net>
# Copyright (c) 2023, Microchip Technology
# All rights reserved.

# Class used to create an UBI image with multiple volumes

# The UBI volume scheme is:
#    ubi0: u-boot env volume
#    ubi1: rootfs volume

inherit image
inherit image_types

IMAGE_TYPES += " ubimg"

do_image_ubimg[depends] += "mtd-utils-native:do_populate_sysroot"

IMAGE_CMD:ubimg () {
    # Added prompt error message for ubi and ubifs image creation.
    if [ -z "${MKUBIFS_ARGS}"] || [ -z "${UBINIZE_ARGS}" ]; then
        bbfatal "MKUBIFS_ARGS and UBINIZE_ARGS have to be set, see http://www.linux-mtd.infradead.org/faq/ubifs.html for details"
    fi

    if [ -z "${UBI_ROOTFS_SIZE}"]; then
        bbfatal "UBI_ROOTFS_SIZE has to be set in machine configuration file"
    fi

    mkdir -p "${WORKDIR}"

    # Workaround for the fact that the image builder requires this directory,
    # despite not using it. If "rm_work" is enabled, this directory won't always
    # exist.
    mkdir -p "${IMAGE_ROOTFS}"

    cat > ${WORKDIR}/ubimg-${IMAGE_NAME}.cfg <<EOF
[env]
mode=ubi
image=${DEPLOY_DIR_IMAGE}/uboot.env
vol_id=0
vol_size=${UBI_ROOTFS_SIZE}KiB
vol_type=dynamic
vol_name=env

[rootfs]
mode=ubi
image=${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubifs
vol_id=1
vol_type=dynamic
vol_name=rootfs
vol_flags=autoresize

EOF

    cat ${WORKDIR}/ubimg-${IMAGE_NAME}.cfg

    # ubinize ubifs volumes
    ubinize -o ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubimg ${UBINIZE_ARGS} ${WORKDIR}/ubimg-${IMAGE_NAME}.cfg

    # Cleanup cfg file
    mv ${WORKDIR}/ubimg-${IMAGE_NAME}.cfg ${IMGDEPLOYDIR}/

}

IMAGE_TYPEDEP:ubimg:append = " ubifs"

# So that we can use the files from excluded paths in the full images.
do_image_ubimg[respect_exclude_path] = "0"
