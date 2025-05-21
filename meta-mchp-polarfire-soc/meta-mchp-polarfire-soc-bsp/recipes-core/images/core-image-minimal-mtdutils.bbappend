# do mtd last
IMAGE_TYPEDEP:mtd += "${IMAGE_FSTYPES}"
IMAGE_TYPEDEP:mtd:remove = "mtd"

IMAGE_INSTALL += "kernel u-boot-mchp"

EXTRA_IMAGE_FEATURES:remove = "package-management ssh-server-openssh"

IMAGE_INSTALL:append = "netcat"

IMAGE_NAME_SUFFIX:mpfs-icicle-kit-es-nand = ""
IMAGE_NAME_SUFFIX:mpfs-icicle-kit-es-nor = ""
