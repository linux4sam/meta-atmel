DESCRIPTION = "Atmel QT smart refrigerator demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=e461c6aa7c87631950f0a71c1552f706"

DEFAULT_PREFERENCE = "11"
PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qt4-embedded libv4l"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/smart-refrigerator-${PV}.tar.gz"

SRC_URI[md5sum] = "ae844f8b37773b2758ae3feb10ada347"
SRC_URI[sha256sum] = "181d73293d11e15736c86ba185a2c1bde97619db331b885f70a7b943de579894"

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
