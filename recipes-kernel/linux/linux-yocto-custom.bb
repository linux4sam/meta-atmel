inherit kernel
require linux-yocto.inc

KERNEL_MAJOR = "3"
KERNEL_MINOR = "12"
KERNEL_REVISION = "6"

PARALLEL_MAKE = "-j10"

###########################################################################

KBRANCH = "linux-${KERNEL_MAJOR}.${KERNEL_MINOR}.y"
KTAG = "v${KERNEL_MAJOR}.${KERNEL_MINOR}.${KERNEL_REVISION}"
SRCREV="${AUTOREV}"
SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${KBRANCH};tag=${KTAG};nocheckout=1 \
	file://defconfig \
	file://${MACHINE}.dts \
"

LINUX_VERSION ?= "${KERNEL_MAJOR}.${KERNEL_MINOR}.${KERNEL_REVISION}"

PR = "${INC_PR}"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "${MACHINE}"
KERNEL_IMAGETYPE = "uImage"

KERNEL_DEVICETREE = "${S}/arch/${TARGET_ARCH}/boot/dts/${MACHINE}.dts"

# Install our own device tree, overriding the default one.
do_install_prepend() {
	cp ${WORKDIR}/${MACHINE}.dts ${S}/arch/${TARGET_ARCH}/boot/dts
}

