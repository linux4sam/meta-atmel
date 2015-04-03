# See poky/meta-skeleton/recipes-kernel/linux/linux-yocto-custom.bb for
# documentation

LINUX_VERSION ?= "3.10"
LINUX_VERSION_EXTENSION ?= "-at91"

KCONFIG_MODE="--alldefconfig"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"

SRCREV = "35158dd80a94df2b71484b9ffa6e642378209156"
SRCREV_sama5d4-xplained = "46f4253693b0ee8d25214e7ca0dde52e788ffe95"
KERNEL_DEVICETREE_sama5d4ek = "sama5d4ek.dtb"

KBRANCH = "linux-3.10-at91"
SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH};nocheckout=1"
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

		cp ${S}/arch/${ARCH}/boot/dts/${MACHINE}*.its ${DTB_PATH}
		cd ${DTB_PATH}
		mkimage -f ${MACHINE}.its ${MACHINE}.itb
		install -m 0644 ${MACHINE}.itb ${DEPLOYDIR}/${MACHINE}.itb
		cd -
	fi
}

KERNEL_MODULE_AUTOLOAD += "atmel_usba_udc g_serial"

COMPATIBLE_MACHINE = "(sama5d4ek|sama5d4-xplained|sama5d3xek|sama5d3-xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek)"
