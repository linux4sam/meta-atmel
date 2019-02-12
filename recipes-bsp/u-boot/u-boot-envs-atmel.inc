# U-Boot Environments for AT91 boards

SRC_URI_append = " file://*.txt"

ENV_SIZE = "0x4000"
ENV_FILENAME = "uboot.env"
ENV_FILEPATH = "${WORKDIR}/envs"

do_deploy_append() {
    if [ -e "${ENV_FILEPATH}/${MACHINE}.txt" ]; then
        echo "Compile u-boot environment for ${MACHINE} and deploy it."
        ${B}/tools/mkenvimage -s ${ENV_SIZE} ${ENV_FILEPATH}/${MACHINE}.txt -o ${ENV_FILENAME}
    else
        echo "No custom environment available for ${MACHINE}."
    fi
}
