DESCRIPTION = "Microchip samegame QT demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=39;md5=8f2a7549bdcd8bed89187e21d29be11f"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtdeclarative"
inherit qmake5

SRC_URI = "git://github.com/linux4sam/samegame.git;protocol=https"
PV = "1.6+git${SRCPV}"
SRCREV = "795cbd545a13ce49d1cde3887a5b7e2d91c46866"

S = "${WORKDIR}/${PN}-${PV}"

inherit pkgconfig

FILES_${PN}-dbg = " \
  /opt/samegame/.debug \
  /opt/samegame/.debug/samegame \
  /usr/* \
  /opt/samegame/samegame.pro \
  /opt/samegame/samegame.qmlproject \
  /opt/samegame/main.cpp \
  /opt/samegame/moc_qmlapplicationviewer.cpp \
"

FILES_${PN} = " \
  /opt/samegame/samegame \
  /opt/samegame/resources/samegame.sh \
  /opt/samegame/qml/* \
  /opt/ApplicationL* \
"

do_install() {
	make INSTALL_ROOT=${D} install
}
