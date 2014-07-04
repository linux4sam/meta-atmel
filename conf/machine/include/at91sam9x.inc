SOC_FAMILY = "at91sam9x"
require conf/machine/include/soc-family.inc

require conf/machine/include/tune-arm926ejs.inc

# List common SoC features
MACHINE_FEATURES = "kernel26 apm ext2 ext3 usbgadget ppp"

# Default providers
PREFERRED_PROVIDER_virtual/kernel = "linux-yocto-custom"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-at91"

# Bootloader settings
require conf/machine/include/bootloaders.inc

UBOOT_ENTRYPOINT = "0x20008000"
UBOOT_LOADADDRESS = "0x20008000"
