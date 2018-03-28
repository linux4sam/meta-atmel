DESCRIPTION = "Microchip QT smart refrigerator demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=e461c6aa7c87631950f0a71c1552f706"

PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtwebkit libv4l qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/smart-refrigerator/archive/v${PV}.tar.gz;downloadfilename=smart-refrigerator-${PV}.tar.gz"

SRC_URI[md5sum] = "8ab327de0d10c725d593fbf53929f124"
SRC_URI[sha256sum] = "413b95c9d31c2625e7184bc5833820780dfa64886c5dba73edb3cfe75959a4a4"

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
