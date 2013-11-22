inherit kernel
require linux-yocto.inc
#require recipes-kernel/linux/linux-yocto.inc

KTAG = "v3.12.1"

LINUX_VERSION ?= "3.12.1"
LINUX_VERSION_EXTENSION ?= "-custom"
KBRANCH ?= "3.12.y"

# Override SRC_URI in a bbappend file to point at a different source
# tree if you do not want to build from Linus' tree.
SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=linux-${KBRANCH}.y;nocheckout=1 \
	file://defconfig \
	file://${MACHINE}.dts \
"

# Override SRCREV to point to a different commit in a bbappend file to
# build a different release of the Linux kernel.
SRCREV="d8f87726b43f1508e3b77a256d71c1b4e4f927ff"

LINUX_VERSION ?= "3.12.1"

PR = "${INC_PR}.0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "${MACHINE}"
KERNEL_IMAGETYPE = "uImage"

KERNEL_DEVICETREE = "${S}/arch/arm/boot/dts/${MACHINE}.dts"

do_install_prepend() {
    cp ${WORKDIR}/${MACHINE}.dts ${S}/arch/arm/boot/dts
}
