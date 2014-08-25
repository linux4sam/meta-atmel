DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=fa39b3d717088cee47df5eeb61b548b3"

DEFAULT_PREFERENCE = "12"
PR = "r1"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtwebkit libv4l"
require recipes-qt/qt5/qt5.inc

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/home-automation-${PV}.tar.gz"

SRC_URI[md5sum] = "cf899bc0902353f8860df31a6135841e"
SRC_URI[sha256sum] = "156b29db8a9ae1617f66ca3907a781ea5446678826dff3b03a822331ddcc09ee"

S = "${WORKDIR}/home-automation-${PV}"

inherit pkgconfig

FILES_${PN}-dbg = " \
	/opt/HomeAutomation/HomeAutomation/.debug \
	/opt/HomeAutomation/.debug/HomeAutomation \
	/usr/* \
	"

FILES_${PN} = " \
	/opt/HomeAutomation/HomeAutomation \
	/opt/HomeAutomation/HomeAutomation.sh \
	/opt/HomeAutomation/atmel-stylesheet.qss \
	/opt/HomeAutomation/resources/* \
	/opt/HomeAutomation/stations/* \
	/opt/HomeAutomation/CustomWidgets/* \
	/opt/HomeAutomation/media/* \
	/opt/HomeAutomation/images/* \
        /opt/ApplicationL* \
	"

do_install() {
	make INSTALL_ROOT=${D} install
	cp -ar ${B}/HomeAutomation ${D}/opt/HomeAutomation/
}
