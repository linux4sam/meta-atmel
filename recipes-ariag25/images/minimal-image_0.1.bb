export IMAGE_BASENAME = "micro-image"
export IMAGE_TYPES = "cpio.gz"
#export IMAGE_FSTYPES = "empty"
export IMAGE_FSTYPES = "cpio.gz"

RPROVIDES_${PN} += "task-boot"
RREPLACES_${PN} += "task-boot"
RCONFLICTS_${PN} += "task-boot"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"
IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

BOOTSTRAP = "at91bootstrap u-boot"

DEPENDS = " \
	virtual/kernel \
	${BOOTSTRAP} \
"

RDEPENDS_${PN} = " \
	angstrom-version \
	busybox \
	${@base_contains("MACHINE_FEATURES", "keyboard", "keymaps", "", d)} \
	${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
"
#base-passwd

RRECOMMENDS_${PN} = "\
	kernel \
	${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
"

DISTRO_UPDATE_ALTERNATIVES ??= ""

# Add ${ROOTFS_PKGMANAGE_PKGS} to IMAGE_INSTALL if desired.
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'


IMAGE_DEV_MANANGER = "udev"
IMAGE_INIT_MANAGER = "sysvinit"

IMAGE_INSTALL = " \
	angstrom-version \
	busybox \
	dropbear \
"

#IMAGE_INITSCRIPTS = " "
#IMAGE_LOGIN_MANAGER = "tinylogin shadow"
IMAGE_LOGIN_MANAGER = " "

inherit image
