DESCRIPTION = "Command line utility for maXTouch devices"
SECTION = "tools"
HOMEPAGE = "https://github.com/atmel-maxtouch/mxt-app"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b6acde4490765c7b838377ac61e2d2d"

DEPENDS = "libusb1"

PV = "1.28+git${SRCPV}"

inherit autotools

SRCREV="e797bf11c749e9959b320f946d25544af458d98a"
SRC_URI = "git://github.com/atmel-maxtouch/mxt-app.git;branch=master;protocol=https"

S = "${WORKDIR}/git"
