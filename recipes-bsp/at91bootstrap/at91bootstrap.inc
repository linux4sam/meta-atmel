SUMMARY = "Initial bootstrap for AT91 ARM MPUs"
DESCRIPTION = " \
		at91bootstrap is the second-level bootloader for Atmel AT91  \
		SoCs. It provides a set of algorithms to manage the hardware \
		initialization and to download the main application (or a    \
		third-level bootloader) from specified boot media to         \
		main memory and start it.                                    \
	      "
AUTHOR = "Atmel Corporation"
HOMEPAGE = "http://www.at91.com/linux4sam/bin/view/Linux4SAM/AT91Bootstrap"
BUGTRACKER = "https://github.com/linux4sam/at91bootstrap/issues"
SECTION = "bootloaders"
LICENSE = "ATMEL"
LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=42f86d2f6fd17d1221c5c651b487a07f"

inherit cml1 deploy

DEPENDS += "bc-native python3-native"

AT91BOOTSTRAP_MACHINE ??= "${MACHINE}"

AT91BOOTSTRAP_CONFIG ??= "${AT91BOOTSTRAP_MACHINE}nf_uboot"
AT91BOOTSTRAP_CONFIG:at91sam9x5ek-sd ??= "${AT91BOOTSTRAP_MACHINE}sd_uboot"
AT91BOOTSTRAP_CONFIG:sama5d3-xplained-sd ??= "${AT91BOOTSTRAP_MACHINE}sd_uboot"
AT91BOOTSTRAP_CONFIG:sama5d4ek ??= "${AT91BOOTSTRAP_MACHINE}nf_uboot_secure"
AT91BOOTSTRAP_CONFIG:sama5d4-xplained ??= "${AT91BOOTSTRAP_MACHINE}nf_uboot_secure"
AT91BOOTSTRAP_CONFIG:sama5d4-xplained-sd ??= "${AT91BOOTSTRAP_MACHINE}sd_uboot_secure"
AT91BOOTSTRAP_CONFIG:sama5d2-xplained ??= "${AT91BOOTSTRAP_MACHINE}-bsrdf_uboot"
AT91BOOTSTRAP_CONFIG:sama5d2-xplained-emmc ??= "${AT91BOOTSTRAP_MACHINE}emmc_uboot"
AT91BOOTSTRAP_CONFIG:sama5d2-xplained-sd ??= "${AT91BOOTSTRAP_MACHINE}-bsrsd_uboot"
AT91BOOTSTRAP_CONFIG:sama5d2-ptc-ek-sd ??= "${AT91BOOTSTRAP_MACHINE}sd_uboot"
AT91BOOTSTRAP_CONFIG:sama5d27-som1-ek ??= "${AT91BOOTSTRAP_MACHINE}qspi_uboot"
AT91BOOTSTRAP_CONFIG:sama5d27-som1-ek-sd ??= "${AT91BOOTSTRAP_MACHINE}sd_uboot"
AT91BOOTSTRAP_CONFIG:sama5d27-som1-ek-optee-sd ??= "${AT91BOOTSTRAP_MACHINE}-opteesd_uboot"
AT91BOOTSTRAP_CONFIG:sama5d27-wlsom1-ek-sd ??= "${AT91BOOTSTRAP_MACHINE}-bsrsd_uboot"
AT91BOOTSTRAP_CONFIG:sama5d2-icp-sd ??= "${AT91BOOTSTRAP_MACHINE}-bsrsd_uboot"
AT91BOOTSTRAP_CONFIG:sam9x60ek ??= "${AT91BOOTSTRAP_MACHINE}nf_uboot"
AT91BOOTSTRAP_CONFIG:sam9x60ek-sd ??= "${AT91BOOTSTRAP_MACHINE}sd_uboot"
AT91BOOTSTRAP_CONFIG:sama7g5ek-sd ??= "${AT91BOOTSTRAP_MACHINE}-bsrsd_uboot"
AT91BOOTSTRAP_CONFIG:sama7g5ek-emmc ??= "${AT91BOOTSTRAP_MACHINE}-bsremmc_uboot"
AT91BOOTSTRAP_CONFIG:sama7g5ek-ospi ??= "${AT91BOOTSTRAP_MACHINE}df_qspi_uboot"
AT91BOOTSTRAP_CONFIG:sam9x60-curiosity ??= "${AT91BOOTSTRAP_MACHINE}nf_uboot"
AT91BOOTSTRAP_CONFIG:sam9x60-curiosity-sd ??= "${AT91BOOTSTRAP_MACHINE}sd_uboot"

AT91BOOTSTRAP_TARGET ??= "${AT91BOOTSTRAP_CONFIG}_defconfig"
AT91BOOTSTRAP_LOAD ??= "nandflashboot-uboot"
AT91BOOTSTRAP_LOAD:at91sam9x5ek-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d2-xplained ??= "dataflashboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d2-xplained-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d27-ptc-ek-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d27-som1-ek ??= "qspiboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d27-som1-ek-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d27-som1-ek-optee-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d27-wlsom1-ek-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d3-xplained-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d4-xplained-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama5d2-icp-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sam9x60ek-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama7g5ek-sd ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama7g5ek-emmc ??= "sdboot-uboot"
AT91BOOTSTRAP_LOAD:sama7g5ek-ospi ??= "dataflashboot-uboot"
AT91BOOTSTRAP_LOAD:sam9x60-curiosity-sd ??= "sdboot-uboot"

AT91BOOTSTRAP_SUFFIX ?= "bin"
AT91BOOTSTRAP_IMAGE ?= "${AT91BOOTSTRAP_MACHINE}-${AT91BOOTSTRAP_LOAD}-${PV}.${AT91BOOTSTRAP_SUFFIX}"
AT91BOOTSTRAP_BINARY ?= "at91bootstrap.${AT91BOOTSTRAP_SUFFIX}"
AT91BOOTSTRAP_SYMLINK ?= "at91bootstrap-${AT91BOOTSTRAP_MACHINE}.${AT91BOOTSTRAP_SUFFIX}"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

do_configure() {
	# Copy board defconfig to .config if .config does not exist. This
	# allows recipes to manage the .config themselves in
	# do_configure:prepend().
	if [ -f "${AT91BOOTSTRAP_CONFIG_PATH}/${AT91BOOTSTRAP_TARGET}" ] && [ ! -f "${B}/.config" ]; then
		cp "${AT91BOOTSTRAP_CONFIG_PATH}/${AT91BOOTSTRAP_TARGET}" "${B}/.config"
	fi

	# Copy defconfig to .config if .config does not exist. This allows
	# recipes to manage the .config themselves in do_configure:prepend()
	# and to override default settings with a custom file.
	if [ -f "${WORKDIR}/defconfig" ] && [ ! -f "${B}/.config" ]; then
		cp "${WORKDIR}/defconfig" "${B}/.config"
	fi

	if [ ! -f "${S}/.config" ]; then
		bbfatal "No config files found"
	fi

	cml1_do_configure
}

do_compile() {
	if [ "${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-gold', 'ld-is-gold', '', d)}" = "ld-is-gold" ] ; then
		sed -i 's/$(CROSS_COMPILE)ld$/$(CROSS_COMPILE)ld.bfd/g' ${S}/Makefile
	fi

	unset CFLAGS CPPFLAGS LDFLAGS
	oe_runmake
}

do_deploy () {
	install -d ${DEPLOYDIR}
	install ${AT91BOOTSTRAP_BIN_PATH}/${AT91BOOTSTRAP_BINARY} ${DEPLOYDIR}/${AT91BOOTSTRAP_IMAGE}

	cd ${DEPLOYDIR}
	rm -f ${AT91BOOTSTRAP_BINARY} ${AT91BOOTSTRAP_SYMLINK}
	ln -sf ${AT91BOOTSTRAP_IMAGE} ${AT91BOOTSTRAP_SYMLINK}
	ln -sf ${AT91BOOTSTRAP_IMAGE} ${AT91BOOTSTRAP_BINARY}

	# Create a symlink ready for file copy on SD card
	rm -f boot.bin BOOT.BIN
	ln -sf ${AT91BOOTSTRAP_IMAGE} BOOT.BIN
}
addtask deploy before do_build after do_compile

PACKAGE_ARCH = "${MACHINE_ARCH}"

TOOLCHAIN = "gcc"
