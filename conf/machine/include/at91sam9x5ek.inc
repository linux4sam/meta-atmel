# Common configuration for Atmel SAM9x5 Evaluation Kits

require conf/machine/include/at91sam9x.inc

MACHINE_FEATURES += "usbhost camera can"

# used by sysvinit_2
SERIAL_CONSOLE ?= "115200 ttyS0"

ROOT_FLASH_SIZE = "256"
IMAGE_FSTYPES += " ubi tar.gz"

# NAND
MKUBIFS_ARGS = " -e 0x1f000 -c 2048 -m 0x800  -x lzo"
UBINIZE_ARGS = " -m 0x800 -p 0x20000 -s 2048"

UBI_VOLNAME = "rootfs"

