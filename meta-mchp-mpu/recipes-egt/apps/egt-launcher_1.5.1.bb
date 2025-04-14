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
	  file://0001-launch.sh-use-systemctl-to-restart-egt.patch"

PV = "1.5.1+git${SRCPV}"
SRCREV = "8eb835928343dad9083c3ce607dffe2f53fd420a"

S = "${WORKDIR}/git"

inherit pkgconfig cmake gettext siteinfo

FILES:${PN} += " \
    /usr/share/egt/* \
"
python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
