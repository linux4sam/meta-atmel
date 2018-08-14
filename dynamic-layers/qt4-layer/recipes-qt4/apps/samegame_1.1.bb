DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=39;md5=8f2a7549bdcd8bed89187e21d29be11f"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r2"

DEPENDS = "qt4-embedded"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/samegame-${PV}.tar.gz"

SRC_URI[md5sum] = "09ba69e5876cff7757f8487c61d2fbf8"
SRC_URI[sha256sum] = "43939d24a1f8b0fcbc8251c2e3dce6fffa9562fe3dc6e16a8c0fe750108f6d04"

S = "${WORKDIR}/samegame-${PV}"

inherit qt4e pkgconfig

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
