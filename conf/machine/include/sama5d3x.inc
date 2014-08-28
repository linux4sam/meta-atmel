SOC_FAMILY = "sama5d3x"
require conf/machine/include/soc-family.inc

DEFAULTTUNE ?= "cortexa5thf"
require conf/machine/include/tune-cortexa5.inc

# Default tune does not use the correct FPU, change CCARGS to fix it.
TUNE_CCARGS += "-mfpu=vfpv4-d16"

# List common SoC features
MACHINE_FEATURES = "kernel26 apm ext2 ext3 usbhost usbgadget ppp"

# Bootloader settings
require conf/machine/include/bootloaders.inc

UBOOT_ENTRYPOINT = "0x20008000"
UBOOT_LOADADDRESS = "0x20008000"
