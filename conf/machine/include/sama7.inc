# Microchip SAMA7 defaults
require conf/machine/include/soc-family.inc
require conf/machine/include/tune-cortexa7.inc
require conf/machine/include/bootloaders.inc

SOC_FAMILY = "sama7"

PREFERRED_PROVIDER_virtual/kernel_sama7 ?= "linux-at91"
PREFERRED_PROVIDER_virtual/bootloader_sama7 ?= "u-boot-at91"
PREFERRED_PROVIDER_u-boot_sama7 ?= "u-boot-at91"

PREFERRED_PROVIDER_jpeg ?= "jpeg"
PREFERRED_PROVIDER_jpeg-native ?= "jpeg-native"

SERIAL_CONSOLES ?= "115200;ttyS0"
WIC_CREATE_EXTRA_ARGS ?= "--no-fstab-update"
EXTRA_IMAGEDEPENDS += "sam-ba-native"

# default kernel defconfig
KBUILD_DEFCONFIG = "sama7_defconfig"
