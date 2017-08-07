DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=39;md5=8f2a7549bdcd8bed89187e21d29be11f"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r2"

DEPENDS = "qtbase qtdeclarative qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/samegame/archive/master.tar.gz;downloadfilename=${PN}-master.tar.gz"

SRC_URI[md5sum] = "0476aebb441293bde6ef9b279aa39042"
SRC_URI[sha256sum] = "c931846ae4fac84167899f6f545c7c3aacbbc2e80b9853ab52b3f80478dc4120"

S = "${WORKDIR}/${PN}-master"

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
