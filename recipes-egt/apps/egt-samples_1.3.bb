DESCRIPTION = "Microchip EGT Theroststat Demo Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"
DEPENDS = " libegt"

SRC_URI = "gitsm://github.com/linux4sam/egt-samples.git;protocol=https;branch=master "

PV = "1.3+git${SRCPV}"
SRCREV = "a2e4030ef59048ff3a0005a5818e4c835290fde3"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

do_configure:prepend() {
     ( cd ${S}; ${S}/autogen.sh; cd -)
}

FILES:${PN} += " \
    /usr/share/egt/* \
"
# out-of-tree building doesn't appear to work for this package.
B = "${S}"

EXTRA_OECONF = "--program-prefix='egt_'"

python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
