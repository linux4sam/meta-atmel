DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=144;md5=f329c5ddb6ba9266deb58683468d316d"

PR = "r1"

DEPENDS = "qt4-embedded"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/application-launcher-${PV}.tar.gz"

SRC_URI[md5sum] = "4a1ab26622e8b22459b4e587a140eb33"
SRC_URI[sha256sum] = "e754e248875c4e3b76415514b48ccaaa12ad77a8cd25722ac7582ac5c8c14fb0"

S = "${WORKDIR}/application-launcher-${PV}"

inherit qt4e pkgconfig

PACKAGES = "${PN}-dbg ${PN}"
FILES_${PN}-dbg = " \
  /opt/ApplicationLauncher/bin/.debug \
  /opt/ApplicationLauncher/bin/.debug/ApplicationLauncher \
  /usr/src/debug/* \
"

FILES_${PN} = " \
  /opt \
  /opt/ApplicationLauncher \
  /opt/ApplicationLauncher/bin \
  /opt/ApplicationLauncher/resources \
  /opt/ApplicationLauncher/qml \
  /opt/ApplicationLauncher/bin/ApplicationLauncher \
  /opt/ApplicationLauncher/resources/halt.jpg \
  /opt/ApplicationLauncher/resources/halt.sh \
  /opt/ApplicationLauncher/resources/shadow.png \
  /opt/ApplicationLauncher/resources/background.jpg \
  /opt/ApplicationLauncher/resources/busy.png \
  /opt/ApplicationLauncher/resources/ApplicationLauncher.sh \
  /opt/ApplicationLauncher/resources/arrow-left.png \
  /opt/ApplicationLauncher/resources/background-1.png \
  /opt/ApplicationLauncher/resources/applications_list.xml \
  /opt/ApplicationLauncher/resources/arrow-right.png \
  /opt/ApplicationLauncher/resources/applications \
  /opt/ApplicationLauncher/resources/applications/resources \
  /opt/ApplicationLauncher/resources/applications/resources/same-game.png \
  /opt/ApplicationLauncher/resources/applications/resources/about-atmel.png \
  /opt/ApplicationLauncher/resources/applications/resources/shadow.png \
  /opt/ApplicationLauncher/resources/applications/resources/app-4.png \
  /opt/ApplicationLauncher/resources/applications/resources/web-browser.png \
  /opt/ApplicationLauncher/resources/applications/resources/picture-viewer.png \
  /opt/ApplicationLauncher/resources/applications/resources/home-automation.png \
  /opt/ApplicationLauncher/resources/applications/resources/busy.png \
  /opt/ApplicationLauncher/resources/applications/resources/minehunter-game.png \
  /opt/ApplicationLauncher/resources/applications/resources/medical-app.png \
  /opt/ApplicationLauncher/resources/applications/resources/about-timesys.png \
  /opt/ApplicationLauncher/qml/ApplicationLauncher \
  /opt/ApplicationLauncher/qml/ApplicationLauncher/ApplicationDelegate.qml \
  /opt/ApplicationLauncher/qml/ApplicationLauncher/Page.qml \
  /opt/ApplicationLauncher/qml/ApplicationLauncher/Busy.qml \ 
  /opt/ApplicationLauncher/qml/ApplicationLauncher/main.qml \
  /opt/ApplicationLauncher/qml/ApplicationLauncher/RssModel.qml \
"

do_install() {
	make INSTALL_ROOT=${D} install
}
