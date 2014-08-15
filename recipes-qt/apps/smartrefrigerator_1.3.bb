DESCRIPTION = "Atmel QT smart refrigerator demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=e461c6aa7c87631950f0a71c1552f706"

DEFAULT_PREFERENCE = "11"
PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtwebkit libv4l"
require recipes-qt/qt5/qt5.inc

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/smart-refrigerator-${PV}.tar.gz"

SRC_URI[md5sum] = "75441b13a9adf6f1fbf743beeff43400"
SRC_URI[sha256sum] = "97f3636b888d567b7a8748830275b3ee445054c8c1630254ed5ef09a86ce80d6"

S = "${WORKDIR}/smart-refrigerator-${PV}"

inherit pkgconfig

FILES_${PN}-dbg = " \
	/opt/SmartRefrigerator/bin \
	/opt/SmartRefrigerator/bin/.debug \
	/opt/SmartRefrigerator/bin/.debug/SmartRefrigerator \
	/opt/SmartRefrigerator/.debug \
	/opt/SmartRefrigerator/.debug/SmartRefrigerator \
	/opt/SmartRefrigerator/CustomWidgets/Fridge-Whiteboard/Canvas/.debug/libcanvasplugin.so \
	/opt/SmartRefrigerator/output/* \
	/usr/* \
	"

FILES_${PN} = " \
	/etc/* \
	/op* \
	"

do_install() {
	make INSTALL_ROOT=${D} install
	cp -ar ${B}/output/SmartRefr* ${D}/opt
	mkdir ${D}/etc
	cp ${B}/output/nhttpd.conf ${D}/etc/nhttpd.conf
	cp -ar ${B}/output/ApplicationL* ${D}/opt
}

pkg_postinst_PACKAGENAME() {
	echo "ma conf a moi" > ${D}/etc/nhttpd.conf
}
