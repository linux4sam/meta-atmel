DESCRIPTION = "Microchip Whiteboard Demo Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase"
inherit qmake5

SRC_URI = "git://github.com/linux4sam/whiteboard.git;protocol=https"
PV = "1.0+git${SRCPV}"
SRCREV = "3d910b2373df365391e3c496270db8c696617abd"

S = "${WORKDIR}/git"

inherit pkgconfig

FILES_${PN}-dbg = " \
  /opt/whiteboard/.debug \
  /opt/whiteboard/.debug/whiteboard \
  /usr/* \
  /opt/whiteboard/whiteboard.pro \
  /opt/whiteboard/whiteboard.qmlproject \
  /opt/whiteboard/main.cpp \
  /opt/whiteboard/moc_qmlapplicationviewer.cpp \
"

FILES_${PN} += " \
  /opt/ApplicationL* \
  /opt/whiteboard/whiteboard \
  /opt/whiteboard/whiteboard.sh \
"

do_install_append() {
	install ${B}/whiteboard ${D}/opt/whiteboard/
}
