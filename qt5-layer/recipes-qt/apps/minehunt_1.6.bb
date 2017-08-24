DESCRIPTION = "Microchip Minehunt Qt demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=40;md5=ade79b42cecba4adb92be7b0e83bad33"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r2"

DEPENDS = "qtbase qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/minehunt/archive/v${PV}.tar.gz;downloadfilename=${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "27469020196251ebdaa78ecd7da46e96"
SRC_URI[sha256sum] = "81cfa87b6cf56fceb755b49462ffac303bd9a3fae2142a94b9f2aceabb0ea689"

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
