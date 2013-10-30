inherit cml1

COMPATIBLE_MACHINE_at91ariag25 = "at91ariag25"
SRC_URI_append_at91sam9x5ek += " \
          file://at91sama5d3xek-add-arch-armv7a-gcc-option.patch \
          file://at91ariag25-add-board-support.patch;patch=1 \
          file://git/board/at91ariag25/at91ariag25.h \
          file://git/board/at91ariag25/at91ariag25.c \
          file://git/board/at91ariag25/at91ariag25sd_uboot_defconfig \
          file://git/board/at91ariag25/board.mk \
		  "
do_configure_at91ariag25() {
    DEFAULT_CONFIG_FILE=${S}/board/${MACHINE}/${MACHINE}sd_uboot_defconfig
    logger ${DEFAULT_CONFIG_FILE}
    if [ ! -f ${S}/.config ]; then
       logger cp ${DEFAULT_CONFIG_FILE} ${S}/.config
       cp ${DEFAULT_CONFIG_FILE} ${S}/.config
    fi
    unset LDFLAGS
    unset CFLAGS
    unset CPPFLAGS
    unset ASFLAGS
    make CROSS_COMPILE=${TARGET_PREFIX} ${MACHINE}sd_uboot_defconfig
}

do_deploy_at91ariag25 () {
    install -d ${DEPLOY_DIR_IMAGE}
    install ${S}/binaries/${MACHINE}-sdcardboot-uboot-3.5.4.bin ${DEPLOY_DIR_IMAGE}/
}
