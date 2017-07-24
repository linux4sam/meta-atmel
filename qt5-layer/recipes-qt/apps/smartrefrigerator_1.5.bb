DESCRIPTION = "Microchip QT smart refrigerator demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=e461c6aa7c87631950f0a71c1552f706"

PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtwebkit libv4l qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/smart-refrigerator/archive/v1.5.tar.gz;downloadfilename=smart-refrigerator-${PV}.tar.gz"

SRC_URI[md5sum] = "6497c4c511bacaacab5637047136c152"
SRC_URI[sha256sum] = "54bdb56a7c45c9193ebf27989414096d0f4df3eddeff9d410c17bcb15ea3af56"

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
	cd ${B}/output/
	for file in $(find SmartRefrigerator ApplicationLauncher -type f); do
		if [ -x ${file} ]; then
			PERM="755"
		else
			PERM="644"
		fi
		echo install -m ${PERM} -D ${file} ${D}/opt/${file}
		install -m ${PERM} -D ${file} ${D}/opt/${file}
	done
	install -d ${D}/etc
	install -m 644 nhttpd.conf ${D}/etc/nhttpd.conf
}

pkg_postinst_PACKAGENAME() {
	echo "ma conf a moi" > ${D}/etc/nhttpd.conf
}
