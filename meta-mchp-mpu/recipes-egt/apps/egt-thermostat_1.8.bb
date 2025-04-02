DESCRIPTION = "Microchip EGT Theroststat Demo Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"
DEPENDS = " libegt"

SRC_URI = "gitsm://github.com/linux4sam/egt-thermostat.git;protocol=https;branch=master"

SRCREV = "f25d928fec6dc086930f574ad8e90bc1e760f6fd"

S = "${WORKDIR}/git"

# out-of-tree building doesn't appear to work for this package.
B = "${S}"

inherit pkgconfig autotools gettext siteinfo

do_configure:prepend() {
    ( cd ${S};
    ${S}/autogen.sh; cd -)
}

FILES:${PN} += " \
    ${datadir}/egt/* \
"

python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
