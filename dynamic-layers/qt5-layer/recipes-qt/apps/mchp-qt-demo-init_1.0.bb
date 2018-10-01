DESCRIPTION = "Init script for qtdemo"
LICENSE = "MIT"
SRC_URI = "file://fs-overlay/etc/mchp_qtdemo \
		  file://fs-overlay/etc/qtprofile.sh"

RDEPENDS_${PN} = "udev-rules-at91"

PR = "r2"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

do_install_append() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/fs-overlay/etc/qtprofile.sh ${D}${sysconfdir}/profile.d/
}

do_install() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/fs-overlay/etc/mchp_qtdemo  ${D}${sysconfdir}/init.d/qtdemo
}

inherit update-rc.d allarch

INITSCRIPT_NAME = "qtdemo"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."

