require u-boot.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

COMPATIBLE_MACHINE = "(sama5d3xek|at91sam9x5ek)"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
UBOOT_MACHINE_${MACHINE} = "${MACHINE}_nandflash_config"
UBOOT_ENTRYPOINT = "0x20002000"
UBOOT_LOADADDRESS = "0x20002000"

# This revision corresponds to the tag "v2012.04.01"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "c1515d14eae4ee3495ede5a8bb49911c600786e4"

PV = "v2012.10-at91"
PR = "r1"

SRC_URI = "git://github.com/linux4sam/u-boot-at91.git;branch=u-boot-2012.10-at91;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
