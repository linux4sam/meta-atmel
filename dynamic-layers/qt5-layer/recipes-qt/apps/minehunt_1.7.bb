DESCRIPTION = "Microchip Minehunt Qt demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=40;md5=ade79b42cecba4adb92be7b0e83bad33"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtdeclarative"
inherit qmake5

SRC_URI = "git://github.com/linux4sam/minehunt.git;protocol=https"
PV = "1.7+git${SRCPV}"
SRCREV = "0bc4b8273dc828827d0e591053a84213c999434c"

S = "${WORKDIR}/git"

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
