DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://main.cpp;endline=40;md5=ade79b42cecba4adb92be7b0e83bad33"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "qt4-embedded"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/minehunt-1.0.tar.gz"

SRC_URI[md5sum] = "44b3a4e2fb81688b6405891c4ed022c8"
SRC_URI[sha256sum] = "8fbe795954840cd37fbc6e9f422983f67d579a5a61557dfc22cf382ea97b25d4"

S = "${WORKDIR}/minehunt-${PV}"

inherit qt4e pkgconfig

FILES_${PN}-dbg = " \
  /opt/minehunt/.debug \
  /opt/minehunt/.debug/* \
  /usr/* \
  /opt/minehunt/minehunt.h \
  /opt/minehunt/minehunt.qmlproject \
  /opt/minehunt/minehunt.cpp \
  /opt/minehunt/main.cpp \
  /opt/minehunt/minehunt.pro \
"

FILES_${PN} = " \
  /opt/minehunt/minehunt \
  /opt/minehunt/resources/minehunt.sh \
  /opt/minehunt/qml/* \
"

do_install() {
	make INSTALL_ROOT=${D} install
}
