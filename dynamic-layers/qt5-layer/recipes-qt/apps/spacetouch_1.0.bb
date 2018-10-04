DESCRIPTION = "Microchip Spacetouch Qt Parallax App"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libplanes"
RDEPENDS_${PN} = "libplanes"

SRC_URI = "git://github.com/linux4sam/spacetouch.git;protocol=https"
PV = "1.0+git${SRCPV}"
SRCREV = "bcf28dda724e8ea6031826dd46c917b917531eb8"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES_${PN}-dbg = " \
  /opt/spacetouch/.debug \
  /usr/* \
"

FILES_${PN} += " \
  /opt/ApplicationL* \
  /opt/spacetouch/spacetouch \
  /opt/spacetouch/spacetouch.sh \
  /opt/spacetouch/spacetouch.screen \
"

do_install_append() {
	install ${B}/spacetouch ${D}/opt/spacetouch/
}
