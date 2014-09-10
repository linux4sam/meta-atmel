DESCRIPTION = "Initial Bootstrap for AT91 ARM MPU"
SECTION = "bootloaders"
LICENSE = "ATMEL"
LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=42f86d2f6fd17d1221c5c651b487a07f"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3_xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek)'

SRCREV="1e8fd41ce7149f7d2063a3b3bcf2c69e77b97732"

PR = "r1"

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=git \
           file://bfa42af7a2c21bada264214d2dd209edc64eb041.patch \
          "

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

AT91BOOTSTRAP_MACHINE ??= "${MACHINE}"
AT91BOOTSTRAP_TARGET ??= "${AT91BOOTSTRAP_MACHINE}nf_uboot_defconfig"
AT91BOOTSTRAP_BINARY ??= "${AT91BOOTSTRAP_MACHINE}-nandflashboot-uboot"

do_configure() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	if [ "${@base_contains('DISTRO_FEATURES', 'ld-is-gold', 'ld-is-gold', '', d)}" = "ld-is-gold" ] ; then
		sed -i 's/$(CROSS_COMPILE)ld$/$(CROSS_COMPILE)ld.bfd/g' ${S}/Makefile	
	fi
	make CROSS_COMPILE=${TARGET_PREFIX} ${AT91BOOTSTRAP_TARGET}
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
	install -d ${DEPLOYDIR}
	install ${S}/binaries/${AT91BOOTSTRAP_BINARY}-${PV}.bin ${DEPLOYDIR}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
