DESCRIPTION = "Minimal initramfs cpio image with a minimal \
set of tools and packages to run MPFS application demos"

LICENSE = "MIT"

DEPENDS += "virtual/bootloader"

IMAGE_INSTALL = "\
    kernel-modules \
    packagegroup-base \
    packagegroup-core-boot \
    packagegroup-mchp-apps \
    packagegroup-mchp-hw-utils \
    packagegroup-mchp-networking \
    packagegroup-mchp-security \
    util-linux \
    "

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = "debug-tweaks"

export IMAGE_BASENAME = "mchp-initramfs-image"
IMAGE_NAME_SUFFIX ?= ""
IMAGE_LINGUAS = ""

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
INITRAMFS_MAXSIZE = "262144"

inherit core-image
