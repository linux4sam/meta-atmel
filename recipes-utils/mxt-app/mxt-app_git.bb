DESCRIPTION = "Command line utility for maXTouch devices"
SECTION = "tools"
HOMEPAGE = "https://github.com/atmel-maxtouch/mxt-app"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b6acde4490765c7b838377ac61e2d2d"

DEPENDS = "libusb1"

PV = "1.28+git${SRCPV}"

inherit autotools

SRCREV="4e9daa7c7606e0bf95b34d1e9736bb8a8d2b29b9"
SRC_URI = "git://github.com/atmel-maxtouch/mxt-app.git"

S = "${WORKDIR}/git"
