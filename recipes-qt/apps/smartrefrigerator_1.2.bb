DESCRIPTION = "Atmel QT smart refrigerator demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=e461c6aa7c87631950f0a71c1552f706"

PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qt4-embedded libv4l"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/smart-refrigerator-${PV}.tar.gz"

SRC_URI[md5sum] = "6933e667240b287b0b85b6c7a826f87a"
SRC_URI[sha256sum] = "a96d09a8e650889ec35c89cfea12261082c351889a4b48252e3ba9f3cfe2398f"

S = "${WORKDIR}/smart-refrigerator-${PV}"

inherit qt4e pkgconfig

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
    	cp -ar ${S}/output/SmartRefr* ${D}/opt
	mkdir ${D}/etc
    	cp ${S}/output/nhttpd.conf ${D}/etc/nhttpd.conf
    	cp -ar ${S}/output/ApplicationL* ${D}/opt

}

pkg_postinst_PACKAGENAME() {
	echo "ma conf a moi" > ${D}/etc/nhttpd.conf
}
