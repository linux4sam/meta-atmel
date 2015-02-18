DESCRIPTION = "Atmel QT5 PTP demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=144;md5=3fd6e13d87198f728613ada223563354"

PR = "r1"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/PTPDemo-${PV}.tar.gz"

SRC_URI[md5sum] = "ca0aee4fdb9692cdc0fb43563b420a18"
SRC_URI[sha256sum] = "58580bf355cdca4e521cc1387896998d77e36a87b0017ec440de34fa42c99bc0"
S = "${WORKDIR}/PTPDemo-${PV}"

DEPENDS = "qtbase"
inherit qmake5

inherit pkgconfig

PACKAGES = "${PN}-dbg ${PN}"
FILES_${PN}-dbg = " \
  /opt/ptp/.debug \
  /opt/ptp/.debug/phc2sys \
  /opt/ptp/.debug/ptp4l \
  /usr/src/debug/* \
  /usr/src/debug \
"

FILES_${PN} = " \
  /opt/ptp/* \
  /opt/ApplicationL* \
"
do_compile_extra() {
	cd ${WORKDIR}/PTPDemo-${PV}/linuxptp-1.3
	make	
}
addtask compile_extra after do_compile before do_install

do_install() {
	make INSTALL_ROOT=${D} install
	cp ${B}/PTPDemo ${D}/opt/ptp/
}
