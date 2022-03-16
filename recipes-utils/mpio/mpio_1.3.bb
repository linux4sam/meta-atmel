DESCRIPTION = "Microchip Peripheral I/O"
LICENSE = "(Apache-2.0 & MIT)"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                   file://LICENSE.MIT;md5=eaff550e3336227837b4efbd2244da32"

PACKAGES = "${PN}-dbg ${PN}"

RDEPENDS:${PN} = "python3"

SRC_URI = "git://github.com/linux4sam/mpio.git;branch=master;protocol=https"
PV = "1.3+git${SRCPV}"

SRCREV = "21c7f5dc185c9bfa3a5a49b25f3a9164bab56ebe"

S = "${WORKDIR}/git"

inherit setuptools_build_meta

PYPA_WHEEL = "${PIP_INSTALL_DIST_PATH}/${PIP_INSTALL_PACKAGE}-*-*.whl"
