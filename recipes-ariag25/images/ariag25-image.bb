DESCRIPTION = "Minimal image with opkg."
require recipes-images/angstrom/console-base-image.bb

export IMAGE_BASENAME = "bootstrap-image"

LICENSE = "GPLv3+"
PR = "r0"

ASSUME_PROVIDED += "qemu"
#PREFERRED_VERSION_qemu = "1.6.1"

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "\
	${CORE_IMAGE_BASE_INSTALL} \
	opkg \
	emacs \
	wget \
	bash \
	busybox \
	systemd \
	connman \
	coreutils \
"

inherit core-image
