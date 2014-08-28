# Common configuration for Atmel SAMA5D3x Evaluation Kits

require conf/machine/include/sama5d3x.inc

# used by sysvinit_2
SERIAL_CONSOLE ?= "115200 ttyS0"

ROOT_FLASH_SIZE = "256"
IMAGE_FSTYPES += " ubi tar.gz"

# NAND
MKUBIFS_ARGS = " -e 0x1f000 -c 2048 -m 0x800  -x lzo"
UBINIZE_ARGS = " -m 0x800 -p 0x20000 -s 2048"

UBI_VOLNAME = "rootfs"

UBOOT_MACHINE = "sama5d3xek_nandflash_config"
UBOOT_FIT_IMAGE = "xyes"
