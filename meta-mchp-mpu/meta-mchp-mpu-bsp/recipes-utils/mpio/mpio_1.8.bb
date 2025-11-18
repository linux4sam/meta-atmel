DESCRIPTION = "Microchip Peripheral I/O"
LICENSE = "(Apache-2.0 & MIT)"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                   file://LICENSE.MIT;md5=eaff550e3336227837b4efbd2244da32"

PACKAGES = "${PN}-dbg ${PN}"

RDEPENDS:${PN} = "python3"

SRC_URI = "git://github.com/linux4sam/mpio.git;branch=master;protocol=https"
PV = "1.8+git${SRCPV}"

SRCREV = "6dbf77d66332e2d614bade8ab742e43a2c30614f"

S = "${WORKDIR}/git"

inherit setuptools3
