DESCRIPTION = "Atmel QT smart refrigerator demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=e461c6aa7c87631950f0a71c1552f706"

PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtwebkit libv4l qtquick1"
inherit qmake5

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/smart-refrigerator-${PV}.tar.gz"

SRC_URI[md5sum] = "c790ebc4169a363d94da4f35dbd2afe8"
SRC_URI[sha256sum] = "6c6cc2203d91f052edc7026a266f6df130f79e3e1c269a008bbfd40ee163f91a"

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
