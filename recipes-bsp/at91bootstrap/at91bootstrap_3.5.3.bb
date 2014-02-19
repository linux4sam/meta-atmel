DESCRIPTION = "Second-level bootstrap for AT91 ARM MPU"
SECTION = "bootloaders"
LICENSE = "ATMEL"
LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=42f86d2f6fd17d1221c5c651b487a07f"

COMPATIBLE_MACHINE = '(sama5d3xek|at91sam9x5ek|at91ariag25)'

PR = "r1"

SRC_URI =  " \
	git://github.com/tanzilli/at91bootstrap.git;branch=ariag25;protocol=http \
"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

inherit deploy
inherit cml1

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_configure () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	make CROSS_COMPILE=${TARGET_PREFIX} ${MACHINE}sd_linux_dt_defconfig
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

addtask deploy before do_package after do_install

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0664 ${S}/binaries/${MACHINE}-*${PV}*.bin ${DEPLOY_DIR_IMAGE}/
}

# Name of binary doesn't follow ${MACHINE} naming convention for the SAMA5D3 series.  Use
# a separate deploy task
do_deploy_sama5d3xek() {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/at91sama5d3xek-nandflashboot-uboot-${PV}.bin ${DEPLOY_DIR_IMAGE}/
}

