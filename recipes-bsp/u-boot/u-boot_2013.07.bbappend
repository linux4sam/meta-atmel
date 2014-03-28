SRCREV = "40cc76407f09ecf79d62247eafbb31dd5c9ffd34"

PV = "v2013.07-at91"
PR = "r2"

COMPATIBLE_MACHINE = "(sama5d3xek|at91sam9x5ek|sama5d3_xplained)"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
UBOOT_MACHINE_${MACHINE} = "${MACHINE}_nandflash_config"
UBOOT_ENTRYPOINT = "0x20002000"
UBOOT_LOADADDRESS = "0x20002000"

SRC_URI = "git://github.com/linux4sam/u-boot-at91.git;branch=u-boot-2013.07-at91;protocol=git"
