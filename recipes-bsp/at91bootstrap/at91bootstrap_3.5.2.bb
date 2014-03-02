DESCRIPTION = "Initial Bootstrap for AT91 ARM MPU"
SECTION = "bootloaders"
LICENSE = "ATMEL"
LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=42f86d2f6fd17d1221c5c651b487a07f"

COMPATIBLE_MACHINE = '(sama5d3xek|at91sam9x5ek)'

PR = "r1"
SRCREV="v3.5.2"
PV="v3.5.2"

SRC_URI =  "git://github.com/linux4sam/at91bootstrap.git;protocol=git"
SRC_URI += "file://at91sama5d3xek-add-arch-armv7a-gcc-option.patch;name=armv7a_patch"

SRC_URI[armv7a_patch.md5sum] = "23cc3bc49cbb3f44f6590c1051bd931f"
SRC_URI[armv7a_patch.sha256sum] = "940d46c55e0f972d99fd5958d0b639516523135226ee48f8c4e919ce3876cde6"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

AT91BOOTSTRAP_MACHINE ??= "${MACHINE}"

do_configure() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	make CROSS_COMPILE=${TARGET_PREFIX} ${AT91BOOTSTRAP_MACHINE}nf_uboot_defconfig
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

addtask deploy before do_package after do_install

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/${AT91BOOTSTRAP_MACHINE}-nandflashboot-uboot-3.5.2.bin ${DEPLOY_DIR_IMAGE}/
}

# Name of binary doesn't follow ${MACHINE} naming convention for the SAMA5D3 series.  Use
# a separate deploy task
do_deploy_sama5d3xek() {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/at91sama5d3xek-nandflashboot-uboot-3.5.2.bin ${DEPLOY_DIR_IMAGE}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
