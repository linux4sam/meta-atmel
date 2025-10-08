require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc
require u-boot-envs-mchp.inc

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;beginline=1;endline=22;md5=b20e22cd4fb2b4c9b05c36b30d58eb89"

DEPENDS += "coreutils-native"

SRC_URI = "git://github.com/linux4microchip/u-boot-mchp.git;protocol=https;branch=${UBRANCH}"
SRCREV	= "bd6afb46f9e27be0b28b6f5ab736c36498d3abaf"

UBRANCH = "u-boot-2025.07-mchp"
PV	= "v2025.07-mchp+git${SRCPV}"
