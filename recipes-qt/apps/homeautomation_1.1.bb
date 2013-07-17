DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=1fcdee2511227a06256bca182ee2ad2c"

DEFAULT_PREFERENCE = "11"
PR = "r1"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qt4-embedded libv4l"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/home-automation-${PV}.tar.gz"

SRC_URI[md5sum] = "c10ebebf22a57ef105dce34df824676e"
SRC_URI[sha256sum] = "32c513f748c44a8fa85e0d2ea2764e0d4e92b42f3a29df1d7544f652085e057f"

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
