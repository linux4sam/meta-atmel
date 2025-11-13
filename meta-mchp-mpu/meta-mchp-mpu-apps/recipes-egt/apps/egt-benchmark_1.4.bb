DESCRIPTION = "Microchip EGT Benchmark Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libegt"

SRC_URI = "gitsm://github.com/linux4sam/egt-benchmark.git;protocol=https;branch=master \
	   file://0001-fix-the-overhead-calibration.patch \
	   "

SRCREV = "114c49c30de8e9182ac33be8a746896d0481c9fd"

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
