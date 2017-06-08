DESCRIPTION = "Command line utility for maXTouch devices"
SECTION = "tools"
HOMEPAGE = "https://github.com/atmel-maxtouch/mxt-app"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b6acde4490765c7b838377ac61e2d2d"

DEPENDS = "libusb1"

PV = "1.27+git${SRCPV}"

inherit autotools

SRCREV="6d84bb0cd4b57a16bc727258ee136ca6ef24dce3"
SRC_URI = "git://github.com/atmel-maxtouch/mxt-app.git"

S = "${WORKDIR}/git"
