DESCRIPTION = "Microchip Peripheral I/O"
LICENSE = "(Apache-2.0 & MIT)"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                   file://LICENSE.MIT;md5=eaff550e3336227837b4efbd2244da32"

PACKAGES = "${PN}-dbg ${PN}"

RDEPENDS_${PN} = "python"

SRC_URI = "git://github.com/linux4sam/mpio.git;branch=master;protocol=https"
PV = "1.0+git${SRCPV}"

SRCREV = "c691030e2897cb285f7a3453f4db49c41921ab26"

S = "${WORKDIR}/git"

inherit setuptools
