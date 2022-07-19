# Microchip SAMA7 defaults
require conf/machine/include/soc-family.inc
require conf/machine/include/arm/armv7a/tune-cortexa7.inc
require conf/machine/include/bootloaders.inc

SOC_FAMILY = "sama7"

PREFERRED_PROVIDER_virtual/kernel:sama7 ?= "linux-at91"
PREFERRED_PROVIDER_virtual/bootloader:sama7 ?= "u-boot-at91"
PREFERRED_PROVIDER_u-boot:sama7 ?= "u-boot-at91"

PREFERRED_PROVIDER_jpeg ?= "jpeg"
PREFERRED_PROVIDER_jpeg-native ?= "jpeg-native"

SERIAL_CONSOLES ?= "115200;ttyS0"
WIC_CREATE_EXTRA_ARGS ?= "--no-fstab-update"

# default kernel defconfig
KBUILD_DEFCONFIG = "sama7_defconfig"
