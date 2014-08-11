require u-boot.inc

# To build u-boot for your machine, provide the following lines in your machine
# config, replacing the assignments as appropriate for your machine.
# UBOOT_MACHINE = "omap3_beagle_config"
# UBOOT_ENTRYPOINT = "0x80008000"
# UBOOT_LOADADDRESS = "0x80008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb \
                    file://README;beginline=1;endline=22;md5=78b195c11cb6ef63e6985140db7d7bab"

SRCREV = "40cc76407f09ecf79d62247eafbb31dd5c9ffd34"

PV = "v2013.07-at91"
PR = "r2"

COMPATIBLE_MACHINE = "(sama5d3xek|at91sam9x5ek|sama5d3_xplained)"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
UBOOT_MACHINE ?= "${MACHINE}_nandflash_config"
UBOOT_ENTRYPOINT ?= "0x20002000"
UBOOT_LOADADDRESS ?= "0x20002000"

SRC_URI = "git://github.com/linux4sam/u-boot-at91.git;branch=u-boot-2013.07-at91;protocol=git"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
