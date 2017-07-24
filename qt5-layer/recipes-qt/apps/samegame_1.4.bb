DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=39;md5=8f2a7549bdcd8bed89187e21d29be11f"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r2"

DEPENDS = "qtbase qtdeclarative qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/samegame/archive/v${PV}.tar.gz;downloadfilename=${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "522e163e0fe6e827b9d9e4e26cb7152a"
SRC_URI[sha256sum] = "8954241cd286c38d08dd49492fc8e98be0d42fa9e62559f42061f68a3bbf45f8"

S = "${WORKDIR}/${PN}-${PV}"

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
