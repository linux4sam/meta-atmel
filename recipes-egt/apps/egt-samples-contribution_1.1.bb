DESCRIPTION = "Microchip EGT sample applications from the community"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d979c7e3d1771e43c4e0ac149beb4d0"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"
DEPENDS = " libegt"

SRC_URI = "git://github.com/linux4sam/egt-samples-contribution.git;protocol=https;branch=master "

PV = "1.1+git${SRCPV}"
SRCREV = "1dacff7e2f810bb7d1a7739a33c601b68c9d452f"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DEGT_SAMPLES_CONTRIBUTION_SLIDERB=true"

inherit pkgconfig cmake

python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
