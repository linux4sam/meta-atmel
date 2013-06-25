DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://main.cpp;endline=39;md5=8f2a7549bdcd8bed89187e21d29be11f"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "qt4-embedded"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/samegame-1.0.tar.gz"

SRC_URI[md5sum] = "41fc017a37f0bd922e31c34551806fa4"
SRC_URI[sha256sum] = "f21c7fc2334617d3228ca0c2a0c70854c3ff347fab3a64736394d59085726186"

S = "${WORKDIR}/samegame-${PV}"

inherit qt4e pkgconfig

FILES_${PN}-dbg = " \
  /opt/samegame/.debug \
  /opt/samegame/.debug/samegame \
  /usr/* \
  /opt/samegame/samegame.pro \
  /opt/samegame/samegame.qmlproject \
  /opt/samegame/main.cpp \
"

FILES_${PN} = " \
  /opt/samegame/samegame \
  /opt/samegame/resources/samegame.sh \
  /opt/samegame/qml/* \
"

do_install() {
	make INSTALL_ROOT=${D} install
}
