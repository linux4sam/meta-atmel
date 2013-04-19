DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://qml/webbrowser/webbrowser.qml;endline=40;md5=a78c797054f097540ddb57fc9212183d"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "qt4-embedded"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/qml-browser-${PV}.tar.gz"

SRC_URI[md5sum] = "1981b50c698fc1fbb327adb84b5d0e61"
SRC_URI[sha256sum] = "24230bf710d8399d3ac017f5aa2cedc188ea1d40548a7a36ebe7ff29ef5d5e14"

S = "${WORKDIR}/qml-browser-${PV}"

inherit qt4e pkgconfig

FILES_${PN}-dbg = " \
  /opt/browser/bin/.debug \
  /opt/browser/bin/.debug/browser \
  /usr/* \
"

FILES_${PN} = " \
  /opt/browser/bin/browser \
  /opt/browser/resources/* \
  /opt/browser/qml/* \
"

do_install() {
	make INSTALL_ROOT=${D} install

}
