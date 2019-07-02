DESCRIPTION = "Microchip Qt View Planes Demo Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libplanes"
RDEPENDS_${PN} = "libplanes"

SRC_URI = "git://github.com/linux4sam/qtviewplanes.git;protocol=https"
PV = "1.0+git${SRCPV}"
SRCREV = "9c2bdb62018f38f1e5a0d12018c89a2634ae4e3a"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES_${PN}-dbg = " \
	/opt/qtviewplanes/.debug \
	/usr/* \
"

FILES_${PN} += " \
	/opt/ApplicationL* \
	/opt/qtviewplanes/qtviewplanes \
	/opt/qtviewplanes/qtviewplanes.screen \
	/opt/qtviewplanes/qtviewplanes.sh \
"

do_install_append() {
	install ${B}/qtviewplanes ${D}/opt/qtviewplanes/
}
