DESCRIPTION = "Initial Bootstrap for AT91 ARM MPU"
SECTION = "bootloaders"
LICENSE = "ATMEL"
LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=42f86d2f6fd17d1221c5c651b487a07f"

COMPATIBLE_MACHINE = '(sama5d3xek|at91sam9x5ek)'

PR = "r2"
SRCREV="v3.5.2"
PV="v3.5.2"

SRC_URI =  "git://github.com/linux4sam/at91bootstrap.git;protocol=git"
SRC_URI += "file://at91sama5d3xek-add-arch-armv7a-gcc-option.patch;name=armv7a_patch \
    ${@base_contains("MACHINE_FEATURES", "watchdog", "file://enable_watchdog.patch", "", d)} \
    "

SRC_URI[armv7a_patch.md5sum] = "23cc3bc49cbb3f44f6590c1051bd931f"
SRC_URI[armv7a_patch.sha256sum] = "940d46c55e0f972d99fd5958d0b639516523135226ee48f8c4e919ce3876cde6"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

do_configure() {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	unset ASFLAGS
	make CROSS_COMPILE=${TARGET_PREFIX} ${MACHINE}nf_uboot_defconfig
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

FILES_${PN} += " \
    /boot/* \
    "

do_install_${MACHINE} () {
    install -d ${D}/boot
    install ${S}/binaries/${MACHINE}-nandflashboot-uboot-3.5.2.bin ${D}/boot
    ln -s /boot/${MACHINE}-nandflashboot-uboot-3.5.2.bin ${D}/boot/at91bootstrap.bin
}

pkg_postinst_${PN} () {
#!/bin/sh -e
# Burn the bootstrap to flash, but only attempt if we're on the actual platform
bootstrap_file=/boot/at91bootstrap.bin
if test "x$D" = "x"; then
    if [ -e "$bootstrap_file" ]; then
        echo "Erasing old bootstrap..."
        flash_erase /dev/mtd0 0 0
        echo "Writing new bootstrap..."
        nandwrite -p /dev/mtd0 "$bootstrap_file"
        echo "Bootstrap upgrade complete."
        touch /var/run/reboot-required
        echo "${PN}" >>/var/run/reboot-required.pkgs
    fi
fi   

}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/${MACHINE}-nandflashboot-uboot-3.5.2.bin ${DEPLOY_DIR_IMAGE}/
}

# Name of binary doesn't follow ${MACHINE} naming convention for the SAMA5D3 series.  Use
# a separate deploy task
do_deploy_sama5d3xek() {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/binaries/at91sama5d3xek-nandflashboot-uboot-3.5.2.bin ${DEPLOY_DIR_IMAGE}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
