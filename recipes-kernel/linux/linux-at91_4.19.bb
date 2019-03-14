SECTION = "kernel"
DESCRIPTION = "Linux kernel for Atmel ARM SoCs (aka AT91)"
SUMMARY = "Linux kernel for Atmel ARM SoCs (aka AT91)"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel

RDEPENDS_${KERNEL_PACKAGE_NAME}-base = ""
FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

SRCREV = "799001827ab69484faf542b09345d3fe97c3e63d"

PV = "4.19+git${SRCPV}"

S = "${WORKDIR}/git"

KBRANCH = "linux-4.19-at91"
SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH}"
SRC_URI += "file://defconfig"

python __anonymous () {
    if d.getVar('UBOOT_FIT_IMAGE', True) == 'xyes':
        d.appendVar('DEPENDS', ' u-boot-mkimage-native dtc-native')
}

do_deploy_append() {
	if [ "${UBOOT_FIT_IMAGE}" = "xyes" ]; then
		DTB_PATH="${B}/arch/${ARCH}/boot/dts/"
		if [ ! -e "${DTB_PATH}" ]; then
			DTB_PATH="${B}/arch/${ARCH}/boot/"
		fi

		if [ -e ${S}/arch/${ARCH}/boot/dts/${MACHINE}.its ]; then
			cp ${S}/arch/${ARCH}/boot/dts/${MACHINE}*.its ${DTB_PATH}
			cd ${DTB_PATH}
			mkimage -f ${MACHINE}.its ${MACHINE}.itb
			install -m 0644 ${MACHINE}.itb ${DEPLOYDIR}/${MACHINE}.itb
			cd -
		fi
	fi
}

kernel_do_configure_append() {
	rm -f ${B}/.scmversion ${S}/.scmversion
	cd ${S}; git status; cd -
}

KERNEL_MODULE_AUTOLOAD += "atmel_usba_udc g_serial"
KERNEL_MODULE_PACKAGE_SUFFIX=""

COMPATIBLE_MACHINE = "(sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd|sama5d4-xplained|sama5d4-xplained-sd|sama5d4ek|sama5d3-xplained|sama5d3-xplained-sd|sama5d3xek|at91sam9x5ek|at91sam9m10g45ek|at91sam9rlek)"
