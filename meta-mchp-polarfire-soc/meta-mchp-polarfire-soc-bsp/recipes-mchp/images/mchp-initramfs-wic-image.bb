DESCRIPTION = "Bootable WIC image with kernel and initramfs"

DEPENDS += "mchp-initramfs-image"
do_image_wic[depends] += "mchp-initramfs-image:do_image_complete"

LICENSE = "MIT"

WKS_FILE_DEPENDS:append ?= " \
    mchp-initramfs-image \
"

WKS_FILE = "mpfs-initramfs.wks"

IMAGE_INSTALL = ""

IMAGE_FSTYPES:remove = " ext4"

do_rootfs[depends] += "mchp-initramfs-image:do_image_complete"

inherit core-image

python do_check_initramfs_image () {
    initramfs_image = d.getVar("INITRAMFS_IMAGE", True)

    if initramfs_image is None or initramfs_image != "mchp-initramfs-image":
        bb.error("INITRAMFS_IMAGE = \"mchp-initramfs-image\" not set")
        bb.fatal("Set it in conf/local.conf to build an Initramfs WIC image ")
}
addtask check_initramfs_image before do_rootfs
