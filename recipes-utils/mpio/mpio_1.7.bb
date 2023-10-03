DESCRIPTION = "Microchip Peripheral I/O"
LICENSE = "(Apache-2.0 & MIT)"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                   file://LICENSE.MIT;md5=eaff550e3336227837b4efbd2244da32"

PACKAGES = "${PN}-dbg ${PN}"

RDEPENDS:${PN} = "python3"

SRC_URI = "git://github.com/linux4sam/mpio.git;branch=master;protocol=https"
PV = "1.7+git${SRCPV}"

SRCREV = "d552e8400d65fecfb37b1bebec0ec63a92409d0a"

S = "${WORKDIR}/git"

inherit setuptools3
