DESCRIPTION = "Microchip QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=fa39b3d717088cee47df5eeb61b548b3"

PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtwebkit libv4l qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/home-automation/archive/v${PV}.tar.gz;downloadfilename=home-automation-${PV}.tar.gz"

SRC_URI[md5sum] = "55b11f945e7d7650ec5242bbcaa71bfe"
SRC_URI[sha256sum] = "27bfb32fb0deddcc65e761aa129c210f1d0484149d59ccc043ef659c47cc4289"

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
	/opt/HomeAutomation/microchip-stylesheet.qss \
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
