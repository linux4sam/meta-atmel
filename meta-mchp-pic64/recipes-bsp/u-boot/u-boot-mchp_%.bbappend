FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS:append:pic64gx = " python3-setuptools-native"
DEPENDS:append:pic64gx = " u-boot-tools-native pic64gx-hss-payload-generator-native"

UBOOT_FILES = " file://${HSS_PAYLOAD}.yaml.in \
                file://${UBOOT_ENV}.cmd \
                file://${MACHINE}.cfg \
            "

SRC_URI:append:pic64gx = " file://envs/"
SRC_URI:append:pic64gx = "${UBOOT_FILES}"

do_deploy:append:pic64gx () {

    if [ ! -f ${DEPLOY_DIR_IMAGE}/zephyr-amp-application.elf ]; then
        if [ "${HSS_PAYLOAD}" = "amp" ]; then
            sed \
                -e "s/@@AMP_DEMO@@/null/g" \
                -e "s/@@AMP_PAYLOAD@@/null/g" \
                -e "s/@@AMP_SKIP-AUTOBOOT@@/true/g" \
                ${WORKDIR}/${HSS_PAYLOAD}.yaml.in > ${WORKDIR}/${HSS_PAYLOAD}.yaml
        else
            cp -f ${WORKDIR}/${HSS_PAYLOAD}.yaml.in ${WORKDIR}/${HSS_PAYLOAD}.yaml
        fi

        hss-payload-generator -c ${WORKDIR}/${HSS_PAYLOAD}.yaml -v ${DEPLOYDIR}/payload.bin
    fi

}

COMPATIBLE_MACHINE:append:pic64gx-curiosity-kit = "|pic64gx-curiosity-kit"
