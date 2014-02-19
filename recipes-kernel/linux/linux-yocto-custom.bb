inherit kernel
require linux-yocto.inc
KERNEL_MAJOR = "3"
KERNEL_MINOR = "13"
KERNEL_REVISION = "3"

# The kernel type determines which subdirectory under "files" to use.  Comment
# this to get a standard kernel.  The RT kernel won't build; this has yet to be
# debugged.
#LINUX_KERNEL_TYPE = "rtlinux"

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
# Validation of the RTLinux patch.
#	https://www.kernel.org/pub/linux/kernel/projects/rt/${KERNEL_MAJOR}.${KERNEL_MINOR}/patch-${KERNEL_MAJOR}.${KERNEL_MINOR}.${KERNEL_REVISION}-rt9.patch.bz2;patch=0 \
#SRC_URI[md5sum] = "fb0531490fc251724133747471f02878"
#SRC_URI[sha256sum] = "3eee8df31f97888980824189264f384561deef43f57b776435d353b51332fcac"

LINUX_VERSION ?= "${KERNEL_MAJOR}.${KERNEL_MINOR}.${KERNEL_REVISION}"

PR = "${INC_PR}"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "${MACHINE}"
KERNEL_IMAGETYPE = "uImage"

KERNEL_DEVICETREE = "${S}/arch/${TARGET_ARCH}/boot/dts/${MACHINE}.dts"

# Apply the RTLinux patch if the kernel type is RTLinux.
do_patch_append () {
	if [ "z${LINUX_KERNEL_TYPE}" = "zrtlinux" ]; then
		cd ${S}
		patch -p1 < ${WORKDIR}/patch-${KERNEL_MAJOR}.${KERNEL_MINOR}.${KERNEL_REVISION}-rt9.patch
	fi
}

# Install our own device tree, overriding the default one.
do_install_prepend() {
	cp ${WORKDIR}/${MACHINE}.dts ${S}/arch/${TARGET_ARCH}/boot/dts
}

