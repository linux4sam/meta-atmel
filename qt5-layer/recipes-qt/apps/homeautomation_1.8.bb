DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=fa39b3d717088cee47df5eeb61b548b3"

PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtwebkit libv4l qtquick1"
inherit qmake5

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/home-automation-${PV}.tar.gz"

SRC_URI[md5sum] = "03f78648457f7f864bfbc932ea50d52d"
SRC_URI[sha256sum] = "a8b58e011ba52013c5d94067a4dd6501e4bd0265470dc114845e2b94c40d528c"

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
	install -m 0755 ${B}/HomeAutomation ${D}/opt/HomeAutomation/
}
