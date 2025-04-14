DESCRIPTION = "Microchip libm2d library to abstract 2D GPUs and provide a common API"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "cairo libdrm libplanes"

SRC_URI = "git://github.com/linux4sam/libm2d.git;protocol=https;branch=master"

SRCREV = "eeecbed5df220adbb3c3f4fb4eaaa5f2d11aea69"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " \
    -DENABLE_TESTS=1 \
"

inherit pkgconfig cmake

FILES:${PN} += " \
    ${datadir}/m2d/* \
"
