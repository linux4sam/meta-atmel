DESCRIPTION = "Microchip Wildwest Qt Parallax App"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libplanes"
RDEPENDS_${PN} = "libplanes"

SRC_URI = "git://github.com/linux4sam/wildwest.git;protocol=https \
           file://0001-wildwest.pro-Add-builddir-to-install-files.patch \
          "
PV = "1.0+git${SRCPV}"
SRCREV = "0b1b22e3eb5c819983f3d14696214ebaabf28223"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

FILES_${PN}-dbg = " \
  /opt/wildwest/.debug \
  /usr/* \
"

FILES_${PN} += " \
  /opt/ApplicationL* \
  /opt/wildwest/wildwest \
  /opt/wildwest/wildwest.sh \
  /opt/wildwest/wildwest.screen \
"

do_install_append() {
	install ${B}/wildwest ${D}/opt/wildwest/
}
