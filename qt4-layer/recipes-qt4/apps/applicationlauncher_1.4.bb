DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=144;md5=f329c5ddb6ba9266deb58683468d316d"

PR = "r1"

DEPENDS = "qt4-embedded"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/application-launcher-${PV}.tar.gz"

SRC_URI[md5sum] = "ed5b80aa1d148f41cf0aea2e3118a786"
SRC_URI[sha256sum] = "8e6fc658d367ab6ff38489f7fe88ca4eca316963653b7e3eb627c698562e80d0"

S = "${WORKDIR}/application-launcher-${PV}"

inherit qt4e pkgconfig

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
