DESCRIPTION = "Microchip QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=fa39b3d717088cee47df5eeb61b548b3"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtmultimedia qtsvg libv4l"

SRC_URI = "git://github.com/linux4sam/home-automation.git;protocol=https;branch=ha-simple"
PV = "2.0+git${SRCPV}"
SRCREV = "7e3f384de01fb2ad3a7b8b6a05acb0d8d68e9508"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

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
