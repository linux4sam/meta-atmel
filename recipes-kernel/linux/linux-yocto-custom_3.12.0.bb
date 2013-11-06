inherit kernel
require linux-yocto.inc
#require recipes-kernel/linux/linux-yocto.inc

KTAG = "v3.12.0"

LINUX_VERSION ?= "3.12.0"
LINUX_VERSION_EXTENSION ?= "-custom"
KBRANCH ?= "3.12.y"

# Override SRC_URI in a bbappend file to point at a different source
# tree if you do not want to build from Linus' tree.
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=linux-${KBRANCH}.y;nocheckout=1"

# Override SRCREV to point to a different commit in a bbappend file to
# build a different release of the Linux kernel.
SRCREV="6b0f1a5c057c686c5e71269418c3944d74d982b1"

SRC_URI += "file://defconfig"
SRC_URI += "file://${MACHINE}.dts"

LINUX_VERSION ?= "3.12.0"

PR = "${INC_PR}.0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "${MACHINE}"
KERNEL_IMAGETYPE = "uImage"

KERNEL_DEVICETREE = "${S}/arch/arm/boot/dts/${MACHINE}.dts"

do_install_prepend() {
    cp ${WORKDIR}/${MACHINE}.dts ${S}/arch/arm/boot/dts
}
