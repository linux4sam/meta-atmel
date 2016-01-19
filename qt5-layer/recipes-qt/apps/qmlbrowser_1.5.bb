DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://qml/webbrowser/webbrowser.qml;endline=40;md5=a78c797054f097540ddb57fc9212183d"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "qtquick1"
inherit qmake5

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/qml-browser-${PV}.tar.gz"

SRC_URI[md5sum] = "48da801a14a2cef77e547d91e334bc51"
SRC_URI[sha256sum] = "8c065f519f979671afc4b49635607bbe891ffe5bcfceb970e77149829bdd3b38"

S = "${WORKDIR}/qml-browser-${PV}"

inherit pkgconfig

FILES_${PN}-dbg = " \
  /opt/browser/bin/.debug \
  /opt/browser/bin/.debug/browser \
  /usr/* \
"

FILES_${PN} = " \
  /opt/browser/bin/browser \
  /opt/browser/resources/* \
  /opt/browser/qml/* \
  /opt/ApplicationL* \
"

do_install() {
	make INSTALL_ROOT=${D} install

}
