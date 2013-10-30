DESCRIPTION = "Initial Bootstrap for AT91 ARM MPU"
SECTION = "bootloaders"
LICENSE = "ATMEL"
LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=42f86d2f6fd17d1221c5c651b487a07f"

COMPATIBLE_MACHINE = '(sama5d3xek|at91sam9x5ek|at91ariag25)'

PR = "r1"
SRCREV="v3.5.4"
PV="v3.5.4"

SRC_URI = " \
		  git://github.com/linux4sam/at91bootstrap.git;protocol=git \
		  file://at91sama5d3xek-add-arch-armv7a-gcc-option.patch \
		  file://at91ariag25-add-board-support.patch;patch=1 \
		  file://git/board/at91ariag25/at91ariag25.h \
		  file://git/board/at91ariag25/at91ariag25.c \
		  file://git/board/at91ariag25/at91ariag25sd_defconfig \
		  file://git/board/at91ariag25/board.mk \
		  "

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""


do_configure() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	make CROSS_COMPILE=${TARGET_PREFIX} ${MACHINE}nf_uboot_defconfig
}

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

do_configure_sama5d3xek() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	make CROSS_COMPILE=${TARGET_PREFIX} at91sama5d3xeknf_uboot_defconfig
}

do_compile() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	make CROSS_COMPILE=${TARGET_PREFIX}
}

inherit deploy
inherit cml1

addtask deploy before do_package after do_install

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/${MACHINE}-nandflashboot-uboot-3.5.4.bin ${DEPLOY_DIR_IMAGE}/
}

do_deploy_at91ariag25 () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/${MACHINE}-sdcardboot-uboot-3.5.4.bin ${DEPLOY_DIR_IMAGE}/
}

# Name of binary doesn't follow ${MACHINE} naming convention for the SAMA5D3 series.  Use
# a separate deploy task
do_deploy_sama5d3xek() {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/at91sama5d3xek-nandflashboot-uboot-3.5.4.bin ${DEPLOY_DIR_IMAGE}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
