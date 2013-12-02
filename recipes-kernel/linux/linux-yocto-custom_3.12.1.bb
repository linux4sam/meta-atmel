DESCRIPTION = "Yocto Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KERNEL_MAJOR = "3"
KERNEL_MINOR = "12"
KERNEL_REVISION = "2"

#########################################################################

LINUX_VERSION = "${KERNEL_MAJOR}.${KERNEL_MINOR}.${KERNEL_REVISION}"
KBRANCH = "linux-${KERNEL_MAJOR}.${KERNEL_MINOR}.y"
KTAG = "v${LINUX_VERSION}"
#SRCREV="0c6f1fb507d5e73cd5bc2e8c6ad91d97febfd85a"
SRCREV="${AUTOREV}"
KERNEL_IMAGETYPE = "uImage"

INC_PR = "r4"

DEPENDS += "xz-native"

# A KMACHINE is the mapping of a yocto $MACHINE to what is built
# by the kernel. This is typically the branch that should be built,
# and it can be specific to the machine or shared
# KMACHINE = "UNDEFINED"

LINUX_KERNEL_TYPE ?= "custom"
LINUX_VERSION_EXTENSION ?= "-yocto-${LINUX_KERNEL_TYPE}"

KERNEL_VERSION = "${LINUX_VERSION}"
# KMETA ?= ""
KBRANCH ?= "master"
KMACHINE ?= "${MACHINE}"
SRCREV_FORMAT ?= "meta_machine"

do_patch[depends] = "kern-tools-native:do_populate_sysroot"

# Pick up shared functions
inherit kernel
inherit kernel-yocto
require linux-dtb.inc


# extra tasks
addtask validate_branches before do_patch after do_kernel_checkout
addtask kernel_link_vmlinux after do_compile before do_install
# addtask kernel_do_configure after do_configure before do_compile
# addtask kernel_configme before do_configure after do_patch
# addtask kernel_configcheck after do_configure before do_compile



SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${KBRANCH};tag=${KTAG};nocheckout=1 \
	file://defconfig \
	file://${MACHINE}.dts \
"
PR = "${INC_PR}"
PV = "${LINUX_VERSION}+git${SRCPV}"
B = "${WORKDIR}/linux-${MACHINE}-${LINUX_KERNEL_TYPE}-build"

COMPATIBLE_MACHINE = "${MACHINE}"
KERNEL_DEVICETREE = "arch/${TARGET_ARCH}/boot/dts/${MACHINE}.dts"


# Override the Yocto patching
do_patch () {
	exit 0
}

# Override the Yocto configuration
do_configure () {
	cp ../defconfig ${S}/arch/${TARGET_ARCH}/configs/${MACHINE}_defconfig
	cd ${S}
	make ARCH=${TARGET_ARCH} ${MACHINE}_defconfig
	kernel_do_configure

	# Allow do_kernel_vmlinux to work.
	mkdir -p ${B}/arch/${ARCH}/boot
	exit 0
}

do_install_prepend() {
	cp ${WORKDIR}/${MACHINE}.dts ${S}/${KERNEL_DEVICETREE}
	install -m 0700 -d ${D}boot
}


# Override the Yocto installation
do_install () {
	#
	# First install the modules
	#
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
	cd ${S}
	if (grep -q -i -e '^CONFIG_MODULES=y$' .config); then
		make DEPMOD=echo ARCH="${TARGET_ARCH}" INSTALL_MOD_PATH="${D}" modules_install
		rm -f "${D}/lib/modules/${KERNEL_VERSION}/build"
		rm -f "${D}/lib/modules/${KERNEL_VERSION}/source"
	else
		bbnote "no modules to install"
	fi

	#
	# Install various kernel output (zImage, map file, config, module support files)
	#
	install -d ${D}/${KERNEL_IMAGEDEST}
	install -d ${D}/boot
	install -m 0644 ${KERNEL_OUTPUT} ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
	install -m 0644 System.map ${D}/boot/System.map-${KERNEL_VERSION}
	install -m 0644 .config ${D}/boot/config-${KERNEL_VERSION}
	install -m 0644 vmlinux ${D}/boot/vmlinux-${KERNEL_VERSION}
	[ -e Module.symvers ] && install -m 0644 Module.symvers ${D}/boot/Module.symvers-${KERNEL_VERSION}
	install -d ${D}${sysconfdir}/modules-load.d
	install -d ${D}${sysconfdir}/modprobe.d

	#
	# Support for external module building - create a minimal copy of the
	# kernel source tree.
	#
	kerneldir=${D}${KERNEL_SRC_PATH}
	install -d $kerneldir

	#
	# Store the kernel version in sysroots for module-base.bbclass
	#

	echo "${KERNEL_VERSION}" > $kerneldir/kernel-abiversion

	#
	# Store kernel image name to allow use during image generation
	#

	echo "${KERNEL_IMAGE_BASE_NAME}" >$kerneldir/kernel-image-name

	#
	# Copy the entire source tree. In case an external build directory is
	# used, copy the build directory over first, then copy over the source
	# dir. This ensures the original Makefiles are used and not the
	# redirecting Makefiles in the build directory.
	#
	# work and sysroots can be on different partitions, so we can't rely on
	# hardlinking, unfortunately.
	#
	find . -depth -not -name "*.cmd" -not -name "*.o" -not -path "./.*" -print0 | cpio --null -pdu $kerneldir
	cp .config $kerneldir
	if [ "${S}" != "${B}" ]; then
		pwd="$PWD"
		cd "${S}"
		find . -depth -not -path "./.*" -print0 | cpio --null -pdu $kerneldir
		cd "$pwd"
	fi
	install -m 0644 ${KERNEL_OUTPUT} $kerneldir/${KERNEL_IMAGETYPE}
	install -m 0644 System.map $kerneldir/System.map-${KERNEL_VERSION}

	#
	# Clean and remove files not needed for building modules.
	# Some distributions go through a lot more trouble to strip out
	# unecessary headers, for now, we just prune the obvious bits.
	#
	# We don't want to leave host-arch binaries in /sysroots, so
	# we clean the scripts dir while leaving the generated config
	# and include files.
	#
	oe_runmake -C $kerneldir CC="${KERNEL_CC}" LD="${KERNEL_LD}" clean
	make -C $kerneldir _mrproper_scripts
	find $kerneldir -path $kerneldir/lib -prune -o -path $kerneldir/tools -prune -o -path $kerneldir/scripts -prune -o -name "*.[csS]" -exec rm '{}' \;
	find $kerneldir/Documentation -name "*.txt" -exec rm '{}' \;

	# As of Linux kernel version 3.0.1, the clean target removes
	# arch/powerpc/lib/crtsavres.o which is present in
	# KBUILD_LDFLAGS_MODULE, making it required to build external modules.
	if [ ${TARGET_ARCH} = "powerpc" ]; then
		cp arch/powerpc/lib/crtsavres.o $kerneldir/arch/powerpc/lib/crtsavres.o
	fi

	# Necessary for building modules like compat-wireless.
	if [ -f include/generated/bounds.h ]; then
		cp include/generated/bounds.h $kerneldir/include/generated/bounds.h
	fi
	if [ -d arch/${TARGET_ARCH}/include/generated ]; then
		mkdir -p $kerneldir/arch/${TARGET_ARCH}/include/generated/
		cp -fR arch/${TARGET_ARCH}/include/generated/* $kerneldir/arch/${TARGET_ARCH}/include/generated/
	fi

	# Remove the following binaries which cause strip or arch QA errors
	# during do_package for cross-compiled platforms
	bin_files="arch/powerpc/boot/addnote arch/powerpc/boot/hack-coff \
	           arch/powerpc/boot/mktree scripts/kconfig/zconf.tab.o \
		   scripts/kconfig/conf.o scripts/kconfig/kxgettext.o"
	for entry in $bin_files; do
		rm -f $kerneldir/$entry
	done

	# kernels <2.6.30 don't have $kerneldir/tools directory so we check if it exists before calling sed
	if [ -f $kerneldir/tools/perf/Makefile ]; then
		# Fix SLANG_INC for slang.h
		sed -i 's#-I/usr/include/slang#-I=/usr/include/slang#g' $kerneldir/tools/perf/Makefile
	fi
}



#do_install_append(){
#	if [ -n "${KMETA}" ]; then
#		rm -rf ${STAGING_KERNEL_DIR}/${KMETA}
#	fi
#}


# Override yocto task.
kernel_do_compile () {
	TOOLCHAIN="$(echo ${CPP} | sed -n -e 's/^\(.*\)gcc.*/\1/p')"
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
	cd ${S}
	make ${PARALLEL_MAKE} ${KERNEL_IMAGETYPE_FOR_MAKE} ARCH="arm" CROSS_COMPILE="${TOOLCHAIN}"
}

# Override yocto task.
do_compile_kernelmodules () {
	TOOLCHAIN="$(echo ${CPP} | sed -n -e 's/^\(.*\)gcc.*/\1/p')"
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
	cd ${S}
	if (grep -q -i -e '^CONFIG_MODULES=y$' .config); then
#		oe_runmake ${PARALLEL_MAKE} modules CC="${KERNEL_CC}" LD="${KERNEL_LD}" ${KERNEL_EXTRA_ARGS}
		make ${PARALLEL_MAKE} modules ARCH="arm" CROSS_COMPILE="${TOOLCHAIN}"
	else
		bbnote "no modules to compile"
	fi
}

# Override yocto task.
kernel_do_deploy () {
	cd ${S}
	install -m 0644 ${KERNEL_OUTPUT} ${DEPLOYDIR}/${KERNEL_IMAGE_BASE_NAME}.bin
	if [ ${MODULE_TARBALL_DEPLOY} = "1" ] && (grep -q -i -e '^CONFIG_MODULES=y$' .config); then
		mkdir -p ${D}/lib
		tar -cvzf ${DEPLOYDIR}/${MODULE_TARBALL_BASE_NAME} -C ${D} lib
		ln -sf ${MODULE_TARBALL_BASE_NAME}.bin ${MODULE_TARBALL_SYMLINK_NAME}
	fi

	cd ${DEPLOYDIR}
	rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.bin
	ln -sf ${KERNEL_IMAGE_BASE_NAME}.bin ${KERNEL_IMAGE_SYMLINK_NAME}.bin
	ln -sf ${KERNEL_IMAGE_BASE_NAME}.bin ${KERNEL_IMAGETYPE}

	cp ${COREBASE}/meta/files/deploydir_readme.txt ${DEPLOYDIR}/README_-_DO_NOT_DELETE_FILES_IN_THIS_DIRECTORY.txt
	cd -
}
do_deploy[dirs] = "${DEPLOYDIR}"
do_deploy[prefuncs] += "package_get_auto_pr"
