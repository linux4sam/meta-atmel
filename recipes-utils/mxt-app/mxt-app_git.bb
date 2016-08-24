DESCRIPTION = "Command line utility for maXTouch devices"
SECTION = "tools"
HOMEPAGE = "https://github.com/atmel-maxtouch/mxt-app"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b6acde4490765c7b838377ac61e2d2d"

DEPENDS = "libusb1"

PR = "r0"
PV = "1.27+git${SRCPV}"

inherit autotools

SRCREV="84665a7b7013285b9f3ee799ee1d9ca7bc6f0e55"
SRC_URI = "git://github.com/atmel-maxtouch/mxt-app.git"

S = "${WORKDIR}/git"
