require u-boot.inc

DEFAULT_PREFERENCE = "-1"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=22;md5=2687c5ebfd9cb284491c3204b726ea29"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/linux4sam/u-boot-at91.git;branch=master"

S = "${WORKDIR}/git"

PV = "2015.01+git${SRCPV}"
