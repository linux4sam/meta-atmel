DESCRIPTION = "Minimal image with opkg."
require recipes-images/angstrom/console-base-image.bb

export IMAGE_BASENAME = "bootstrap-image"

LICENSE = "GPLv3+"
PR = "r0"

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "\
	${CORE_IMAGE_BASE_INSTALL} \
	opkg \
"

inherit core-image
