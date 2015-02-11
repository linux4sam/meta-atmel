DESCRIPTION = "Command line utility for maXTouch devices"
SECTION = "tools"
HOMEPAGE = "https://github.com/atmel-maxtouch/obp-utils"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b6acde4490765c7b838377ac61e2d2d"

DEPENDS = ""

PR = "r0"

inherit autotools

SRCREV="6c0bd1941fbe66a13ff066cac8ec5d1b5f8931a7"
SRC_URI = "git://github.com/atmel-maxtouch/obp-utils.git;protocol=git \
           file://0001-Allow-building-out-of-tree.patch"

S = "${WORKDIR}/git"
