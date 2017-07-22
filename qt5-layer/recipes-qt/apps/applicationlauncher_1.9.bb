DESCRIPTION = "Microchip QT5 Application Launcher demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://COPYING;md5=78a72a436c89c3863a5650347f34a3b3"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtdeclarative qtwebkit qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/application-launcher/archive/qt59.zip"

#SRC_URI_append_sama5d4 += "file://applicationlauncher_videoplayer.patch"

SRC_URI[md5sum] = "ea78315aa048ff122aa2cabf6a453f92"
SRC_URI[sha256sum] = "95d2ade50ea00d0ec65f9103bfcf6ecaf522f785af582a560049817f76bf08d2"

S = "${WORKDIR}/application-launcher-qt59"

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
  /opt/ApplicationLauncher/applications_list.xml \
"
do_install() {
	make INSTALL_ROOT=${D} install
	cp ${S}/applications_list.xml ${D}/opt/ApplicationLauncher/
}
