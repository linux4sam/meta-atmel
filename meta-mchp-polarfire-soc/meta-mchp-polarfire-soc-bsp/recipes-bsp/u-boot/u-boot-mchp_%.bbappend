FILESEXTRAPATHS:prepend:mpfs := "${THISDIR}/files:"

DEPENDS:append:mpfs = " python3-setuptools-native"
DEPENDS:append:mpfs = " u-boot-tools-native hss-payload-generator-native"
DEPENDS:append:mpfs-icicle-kit-amp = " polarfire-soc-amp-examples"

UBOOT_FILES:mpfs = " file://${UBOOT_ENV}.cmd \
                file://${MACHINE}.cfg \
                file://${HSS_PAYLOAD}.yaml"


SRC_URI:append:mpfs = " file://envs/"
SRC_URI:append:mpfs-icicle-kit-all = "${UBOOT_FILES}"
SRC_URI:append:mpfs-disco-kit = "${UBOOT_FILES}"
SRC_URI:append:mpfs-video-kit = "${UBOOT_FILES}"

SRC_URI:append:mpfs-icicle-kit-auth = " file://${MACHINE}.env"
SRC_URI:remove:mpfs-icicle-kit-auth = " file://${UBOOT_ENV}.cmd"

do_configure:append:mpfs-icicle-kit-auth () {
    cp -f ${WORKDIR}/${MACHINE}.env ${S}/board/microchip/mpfs_icicle
}

do_deploy:append:mpfs () {

    #
    # for icicle-kit-es-amp, we'll already have an amp-application.elf in
    # DEPLOY_DIR_IMAGE, so smuggle it in here for the payload generator ...
    #
    if [ -f "${DEPLOY_DIR_IMAGE}/amp-application.elf" ]; then
        cp -f ${DEPLOY_DIR_IMAGE}/amp-application.elf ${DEPLOYDIR}
    fi

    if [ "${MACHINE}" = "mpfs-icicle-kit-auth-prod" ] || [ "${MACHINE}" = "mpfs-icicle-kit-es-auth" ]; then

        if [ ! -f "${HSS_PAYLOAD_KEYDIR}/${HSS_PAYLOAD_PRIVATE_KEYNAME}.pem" ];then
            bbfatal "Authentication Boot file check, missing: ${HSS_PAYLOAD_KEYDIR}/${HSS_PAYLOAD_PRIVATE_KEYNAME}.pem, Refer to the Polarfire SoC Documentation"
        fi

        if [ ! -f "${UBOOT_SIGN_KEYDIR}/${UBOOT_SIGN_KEYNAME}.crt" ];then
            bbfatal "Authentication Boot file check, missing: ${UBOOT_SIGN_KEYDIR}/${UBOOT_SIGN_KEYNAME}.crt, Refer to the Polarfire SoC Documentation"
        fi

        if [ ! -f "${UBOOT_SIGN_KEYDIR}/${UBOOT_SIGN_KEYNAME}.key" ];then
            bbfatal "Authentication Boot file check,  missing: ${UBOOT_SIGN_KEYDIR}/${UBOOT_SIGN_KEYNAME}.key, Refer to the Polarfire SoC Documentation"
        fi

        bbplain "Using Signing Keys Located in ${HSS_PAYLOAD_KEYDIR}"

        hss-payload-generator -c ${WORKDIR}/${HSS_PAYLOAD}.yaml -v ${DEPLOYDIR}/payload.bin -p ${HSS_PAYLOAD_KEYDIR}/${HSS_PAYLOAD_PRIVATE_KEYNAME}.pem

    else
        hss-payload-generator -c ${WORKDIR}/${HSS_PAYLOAD}.yaml -v ${DEPLOYDIR}/payload.bin
    fi

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
