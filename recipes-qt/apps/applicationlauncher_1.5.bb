DESCRIPTION = "Atmel QT5 Application Launcher demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=144;md5=f329c5ddb6ba9266deb58683468d316d"

PR = "r3"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/application-launcher-${PV}.tar.gz"
SRC_URI += "file://applicationlauncher_adaptor_screen.patch"

SRC_URI[md5sum] = "1ba89fbe0d2416a2e012581921d8a61a"
SRC_URI[sha256sum] = "0eece411beb8b01323f105fd8f3a8bf1193c455ea1517a233063c14ebae958ee"

S = "${WORKDIR}/application-launcher-${PV}"

DEPENDS = "qtbase qtdeclarative qtwebkit qtquick1"
#RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtdeclarative-plugins"
inherit qmake5

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
