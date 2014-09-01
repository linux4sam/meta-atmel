DESCRIPTION = "Atmel QT5 Application Launcher demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=144;md5=f329c5ddb6ba9266deb58683468d316d"

PR = "r1"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/application-launcher-${PV}.tar.gz"

SRC_URI[md5sum] = "df427daf50fbc7095ffafd09f30e5a10"
SRC_URI[sha256sum] = "25913a38cf96d00fe3010fcb985dc655e52dcaac75560f0a8fc8271c62ada9cc"

S = "${WORKDIR}/application-launcher-${PV}"

DEPENDS = "qtbase qtdeclarative qtwebkit qtquick1"
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
