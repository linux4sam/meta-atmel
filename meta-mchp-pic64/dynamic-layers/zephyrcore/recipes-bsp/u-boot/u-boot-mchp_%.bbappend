DEPENDS:append:pic64gx:pic64gx-curiosity-kit-amp = " pic64gx-zephyr-amp-demo-hss"

do_deploy:append:pic64gx-curiosity-kit-amp () {

    #
    # for pic64gx-curiosity-kit-amp, we'll already have an zephyr-amp-application.elf in
    # DEPLOY_DIR_IMAGE, so smuggle it in here for the payload generator ...
    # then clean-up here before the Yocto framework gets angry that we're trying to install
    # files (from DEPLOYDIR) into a shared area (DEPLOY_IMAGE_DIR) when they already exist
    #

    if [ -f ${DEPLOY_DIR_IMAGE}/zephyr-amp-application.elf ]; then
        cp ${DEPLOY_DIR_IMAGE}/zephyr-amp-application.elf ${DEPLOYDIR}/zephyr-amp-application.elf
        sed \
            -e "s/@@AMP_DEMO@@/${AMP_DEMO}/g" \
            -e "s/@@AMP_PAYLOAD@@/zephyr-amp-application.elf/g" \
            -e "s/@@AMP_SKIP-AUTOBOOT@@/false/g" \
            ${WORKDIR}/${HSS_PAYLOAD}.yaml.in > ${WORKDIR}/${HSS_PAYLOAD}.yaml
        hss-payload-generator -c ${WORKDIR}/${HSS_PAYLOAD}.yaml -v ${DEPLOYDIR}/payload.bin
        rm -f ${DEPLOYDIR}/zephyr-amp-application.elf
    fi

}
