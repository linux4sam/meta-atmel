DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=39;md5=8f2a7549bdcd8bed89187e21d29be11f"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r2"

DEPENDS = "qtbase qtdeclarative qtquick1"
inherit qmake5

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/samegame-${PV}.tar.gz"

SRC_URI[md5sum] = "0d2bc97f822dac318092f029ced5b2ca"
SRC_URI[sha256sum] = "6de46c2bfb27bdeac416ad9b34e795fa66b9e9c41b209a30edf16d137b32b92a"

S = "${WORKDIR}/samegame-${PV}"

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
