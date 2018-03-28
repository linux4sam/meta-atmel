DESCRIPTION = "Microchip Minehunt Qt demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=40;md5=ade79b42cecba4adb92be7b0e83bad33"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/minehunt/archive/v${PV}.tar.gz;downloadfilename=${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "c7bff519050bdd1daddc8f3a8eb92f5d"
SRC_URI[sha256sum] = "17d7f0141bfb038819ee5b0e3706422865dad146776bbb641633c7fc8c937954"

S = "${WORKDIR}/${PN}-${PV}"

inherit pkgconfig

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
