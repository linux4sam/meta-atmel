DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=40;md5=ade79b42cecba4adb92be7b0e83bad33"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r2"

DEPENDS = "qtbase qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/minehunt/archive/master.tar.gz;downloadfilename=${PN}-master.tar.gz"

SRC_URI[md5sum] = "0396e7e008940fbd11e38935eaa3809b"
SRC_URI[sha256sum] = "e51c9b08d0e5bcb836642189e194fecf26f651729d7a81a8b2de1a900c77e820"

S = "${WORKDIR}/${PN}-master"

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
