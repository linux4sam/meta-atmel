DESCRIPTION = "Microchip QT5 Application Launcher demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://COPYING;md5=78a72a436c89c3863a5650347f34a3b3"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtdeclarative qtwebkit qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/application-launcher/archive/v${PV}.tar.gz;downloadfilename=application-launcher-${PV}.tar.gz"

S = "${WORKDIR}/application-launcher-${PV}"

inherit pkgconfig

PACKAGES = "${PN}-dbg ${PN}"
FILES_${PN}-dbg = " \
  /opt/ApplicationLauncher/bin/.debug \
  /opt/ApplicationLauncher/bin/.debug/ApplicationLauncher \
  /usr/src/debug/* \
  /opt/ApplicationLauncher/applications/resources/same-game.png \
  /opt/ApplicationLauncher/applications/resources/about-atmel.png \
  /opt/ApplicationLauncher/applications/resources/picture-viewer.png \
  /opt/ApplicationLauncher/applications/resources/home-automation.png \
  /opt/ApplicationLauncher/applications/resources/medical-app.png \
  /opt/ApplicationLauncher/applications/resources/about-timesys.png \
"

FILES_${PN} = " \
  /opt \
  /opt/ApplicationLauncher \
  /opt/ApplicationLauncher/applications_list.xml \
"
do_install() {
	make INSTALL_ROOT=${D} install
	cp ${S}/applications_list.xml ${D}/opt/ApplicationLauncher/
}
