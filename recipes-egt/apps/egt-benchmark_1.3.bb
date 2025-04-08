DESCRIPTION = "Microchip EGT Benchmark Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libegt"

SRC_URI = "gitsm://github.com/linux4sam/egt-benchmark.git;protocol=https;branch=master"

SRCREV = "3b73339bd5862dfac15c1126969f9dcd84d2ea2e"

S = "${WORKDIR}/git"

inherit pkgconfig cmake siteinfo

FILES:${PN} += " \
    ${datadir}/egt/* \
"

python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
