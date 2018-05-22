DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=40;md5=ade79b42cecba4adb92be7b0e83bad33"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r2"

DEPENDS = "qt4-embedded"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/minehunt-${PV}.tar.gz"

SRC_URI[md5sum] = "a55072e4ac03e38560705a1f3e773da0"
SRC_URI[sha256sum] = "7a3ce058bf3db14f7bb8e9eb2a13221428cf0b16840a4ed428ca20fa3456fea2"

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
  /opt/minehunt/qrc_minehunt.cpp \
  /opt/minehunt/moc_minehunt.cpp \
  /opt/minehunt/moc_qmlapplicationviewer.cpp \
"

FILES_${PN} = " \
  /opt/minehunt/minehunt \
  /opt/minehunt/resources/minehunt.sh \
  /opt/minehunt/qml/* \
  /opt/ApplicationL* \
"

do_install() {
	make INSTALL_ROOT=${D} install
}
