DESCRIPTION = "Command line utility for maXTouch devices"
SECTION = "tools"
HOMEPAGE = "https://github.com/atmel-maxtouch/mxt-app"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b6acde4490765c7b838377ac61e2d2d"

DEPENDS = "libusb1"

PR = "r0"

inherit autotools

SRCREV="baa2ab851272f78bf05883861e8098008213a2c2"
SRC_URI = "git://github.com/atmel-maxtouch/mxt-app.git"

S = "${WORKDIR}/git"
