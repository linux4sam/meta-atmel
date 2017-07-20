DESCRIPTION = "Init script for weston"
LICENSE = "MIT"
SRC_URI = "file://fs-overlay/etc/weston \
		  file://fs-overlay/etc/weston.ini "
PR = "r2"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

do_install() {
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/fs-overlay/etc/weston		${D}${sysconfdir}/default/weston
	install -m 0755 ${WORKDIR}/fs-overlay/etc/weston.ini 	${D}${sysconfdir}/weston.ini
}

