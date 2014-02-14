DESCRIPTION = "Initial Bootstrap for AT91 ARM MPU"
SECTION = "bootloaders"
LICENSE = "ATMEL"
LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=42f86d2f6fd17d1221c5c651b487a07f"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3_xplained|at91sam9x5ek|at91sam9rlek)'

# 5415d4e3ff7f4a9a2404d71c8c2e277c7b7c1e67 -> tag v3.6.1
SRCREV="5415d4e3ff7f4a9a2404d71c8c2e277c7b7c1e67"

PR = "r1"

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=git"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

do_configure() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	make CROSS_COMPILE=${TARGET_PREFIX} ${MACHINE}nf_uboot_defconfig
}

do_compile() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	make CROSS_COMPILE=${TARGET_PREFIX}
}

inherit deploy

addtask deploy before do_package after do_install

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/${MACHINE}-nandflashboot-uboot-${PV}.bin ${DEPLOY_DIR_IMAGE}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
