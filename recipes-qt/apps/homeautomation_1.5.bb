DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=1fcdee2511227a06256bca182ee2ad2c"

PR = "r1"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qt4-embedded libv4l"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/home-automation-${PV}.tar.gz"

SRC_URI[md5sum] = "90f74e04beeb0e80ba75905ede188714"
SRC_URI[sha256sum] = "7efe67de3ccd2fb1441016f00112f75ddff7dae531d26889a0da1935f964fde4"

S = "${WORKDIR}/home-automation-${PV}"

inherit qt4e pkgconfig

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

}
