FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS:append = " python3-setuptools-native"
DEPENDS:append = " u-boot-tools-native hss-payload-generator-native"
DEPENDS:append:mpfs-icicle-kit-es-amp = " polarfire-soc-amp-examples"

UBOOT_FILES = " file://${UBOOT_ENV}.cmd \
                file://${MACHINE}.cfg \
                file://${HSS_PAYLOAD}.yaml"


SRC_URI:append = " file://envs/"
SRC_URI:append:mpfs-icicle-kit-all = "${UBOOT_FILES}"
SRC_URI:append:mpfs-disco-kit = "${UBOOT_FILES}"
SRC_URI:append:mpfs-video-kit = "${UBOOT_FILES}"

do_deploy:append () {

    #
    # for icicle-kit-es-amp, we'll already have an amp-application.elf in
    # DEPLOY_DIR_IMAGE, so smuggle it in here for the payload generator ...
    #
    if [ -f "${DEPLOY_DIR_IMAGE}/amp-application.elf" ]; then
        cp -f ${DEPLOY_DIR_IMAGE}/amp-application.elf ${DEPLOYDIR}
    fi

    hss-payload-generator -c ${WORKDIR}/${HSS_PAYLOAD}.yaml -v ${DEPLOYDIR}/payload.bin

    #
    # for icicle-kit-es-amp, if we smuggled in an amp-application.elf, then
    # clean-up here before the Yocto framework gets angry that we're trying to install
    # files (from DEPLOYDIR) into a shared area (DEPLOY_IMAGE_DIR) when they already
    # exist
    #
    if [ -f "${DEPLOYDIR}/amp-application.elf" ]; then
        rm -f ${DEPLOYDIR}/amp-application.elf
    fi

}
