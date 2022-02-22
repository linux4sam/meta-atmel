DESCRIPTION = "Microchip EGT launcher Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"
DEPENDS = "libegt"

RDEPENDS:${PN} = "evtest"

SRC_URI = "git://github.com/linux4sam/egt-launcher.git;protocol=https;branch=master \
	  file://0001-launch.sh-Use-start-stop-daemon-to-restart-egt.patch"

PV = "1.1+git${SRCPV}"
SRCREV = "d1559803806bba26fe3a4b3f7aff2ddaa439534d"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

do_configure:prepend() {
	( cd ${S};
	${S}/autogen.sh; cd -)
}

# out-of-tree building doesn't appear to work for this package.
B = "${S}"

FILES:${PN} += " \
    /usr/share/egt/* \
"
python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
