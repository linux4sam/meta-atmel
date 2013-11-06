DESCRIPTION = "Minimal image with opkg."
require recipes-images/angstrom/console-base-image.bb

export IMAGE_BASENAME = "bootstrap-image"

LICENSE = "GPLv3+"
PR = "r0"

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
	nfs-client \
	connman \
	coreutils \
"

inherit core-image
