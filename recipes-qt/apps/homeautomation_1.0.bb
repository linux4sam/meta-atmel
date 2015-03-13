DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=1fcdee2511227a06256bca182ee2ad2c"

PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qt4-embedded libv4l"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/home-automation-${PV}.tar.gz"

SRC_URI[md5sum] = "8f92bdc450854a7aa31f6c65a4fbd6bc"
SRC_URI[sha256sum] = "7b4ac19703f0ba8f1d573e4d033d3927c83e00723ad309c5eaf3cadf0c73d1de"

S = "${WORKDIR}/home-automation-${PV}"

inherit qt4e pkgconfig

FILES_${PN}-dbg = " \
	/opt/HomeAutomation/HomeAutomation/.debug \
	/opt/HomeAutomation/.debug/HomeAutomation \
	/usr/* \
	"

FILES_${PN} = " \
	/opt/HomeAutomation/HomeAutomation \
	/opt/HomeAutomation/atmel-stylesheet.qss \
	/opt/HomeAutomation/resources/* \
	/opt/HomeAutomation/CustomWidgets/* \
	/opt/HomeAutomation/media/* \
	/opt/HomeAutomation/images/* \
	"

do_install() {
	make INSTALL_ROOT=${D} install

}
