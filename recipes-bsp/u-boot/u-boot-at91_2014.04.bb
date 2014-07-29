require u-boot.inc

# To build u-boot for your machine, provide the following lines in your machine
# config, replacing the assignments as appropriate for your machine.
# UBOOT_MACHINE = "omap3_beagle_config"
# UBOOT_ENTRYPOINT = "0x80008000"
# UBOOT_LOADADDRESS = "0x80008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=22;md5=2687c5ebfd9cb284491c3204b726ea29"

SRCREV_sama5d4ek = "dbd54338273fdf8a1301e1f840bdde2d3d41cb05"

PV = "v2014.04-at91"
PR = "r0"

COMPATIBLE_MACHINE = "(sama5d4ek)"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
#UBOOT_MACHINE_${MACHINE} = "${MACHINE}_nandflash_config"
UBOOT_MACHINE_${MACHINE} = "${MACHINE}_nandflash_config"
UBOOT_ENTRYPOINT = "0x20002000"
UBOOT_LOADADDRESS = "0x20002000"

SRC_URI = "git://git@github.com/linux4sam/u-boot-at91-timesys.git;branch=sama5d4/u-boot-2014.04-sama5d4;protocol=ssh"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
