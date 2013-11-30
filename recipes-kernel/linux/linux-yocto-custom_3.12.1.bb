PR = "1"

KERNEL_MAJOR_VERSION = "3"
KERNEL_MINOR_VERSION = "12"
KERNEL_REVISION      = "1"

KERNEL_IMAGETYPE = "uImage"

# 3.11.9
#SRCREV = "99b0056025d58534b2cb22a5de195b4042b0546c"
# 3.11.6
#SRCREV = "3445f1750a290bf20641007cda08f21e33b34c87"
# 3.12.1
SRCREV = "d8f87726b43f1508e3b77a256d71c1b4e4f927ff"

################################

DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KTAG = "v${KERNEL_MAJOR_VERSION}.${KERNEL_MINOR_VERSION}.${KERNEL_REVISION}"
KBRANCH ?= "${KERNEL_MAJOR_VERSION}.${KERNEL_MINOR_VERSION}.y"
SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=linux-${KBRANCH};nocheckout=1 \
	file://defconfig \
	file://${MACHINE}.dts \
"

LINUX_KERNEL_TYPE = "custom"
LINUX_VERSION ?= "${KERNEL_MAJOR_VERSION}.${KERNEL_MINOR_VERSION}.${KERNEL_REVISION}"
LINUX_VERSION_EXTENSION ?= "-yocto-${LINUX_KERNEL_TYPE}"
COMPATIBLE_MACHINE = "${MACHINE}"
KMACHINE = "${MACHINE}"

PV = "${LINUX_VERSION}"

KERNEL_DEVICETREE = "${S}/arch/arm/boot/dts/${MACHINE}.dts"

inherit kernel
inherit kernel-yocto
require linux-dtb.inc

S = "${WORKDIR}/linux"

B = "${WORKDIR}/linux-${MACHINE}-${LINUX_KERNEL_TYPE}-build"

DEPENDS += "xz-native"
do_patch[depends] = "kern-tools-native:do_populate_sysroot"

addtask kernel_configme before do_configure after do_patch
addtask kernel_link_vmlinux after do_compile before do_install
addtask validate_branches before do_patch after do_kernel_checkout
addtask kernel_configcheck after do_configure before do_compile

do_install_prepend() {
	cp ${WORKDIR}/${MACHINE}.dts ${S}/arch/arm/boot/dts
}

do_install_append(){
	if [ -n "${KMETA}" ]; then
	   rm -rf ${STAGING_KERNEL_DIR}/${KMETA}
	fi
}

