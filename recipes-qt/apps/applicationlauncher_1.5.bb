DESCRIPTION = "Atmel QT5 Application Launcher demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=144;md5=f329c5ddb6ba9266deb58683468d316d"

PR = "r1"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/application-launcher-${PV}.tar.gz"

SRC_URI[md5sum] = "e3b4d39f4d47b9ba93c1ef7278808d31"
SRC_URI[sha256sum] = "0663880cde1cf7a6833e3780c39479616026dafd301db188c063f51eade4ec26"

S = "${WORKDIR}/application-launcher-${PV}"

DEPENDS = "qtbase qtdeclarative qtwebkit"
#RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtdeclarative-plugins"
require recipes-qt/qt5/qt5.inc

inherit pkgconfig

PACKAGES = "${PN}-dbg ${PN}"
FILES_${PN}-dbg = " \
  /opt/ApplicationLauncher/bin/.debug \
  /opt/ApplicationLauncher/bin/.debug/ApplicationLauncher \
  /usr/src/debug/* \
  /opt/ApplicationLauncher/applications/resources/same-game.png \
  /opt/ApplicationLauncher/applications/resources/about-atmel.png \
  /opt/ApplicationLauncher/applications/resources/web-browser.png \
  /opt/ApplicationLauncher/applications/resources/picture-viewer.png \
  /opt/ApplicationLauncher/applications/resources/home-automation.png \
  /opt/ApplicationLauncher/applications/resources/minehunter-game.png \
  /opt/ApplicationLauncher/applications/resources/medical-app.png \
  /opt/ApplicationLauncher/applications/resources/about-timesys.png \
"

FILES_${PN} = " \
  /opt \
  /opt/ApplicationLauncher \
"
do_install() {
	make INSTALL_ROOT=${D} install
}
