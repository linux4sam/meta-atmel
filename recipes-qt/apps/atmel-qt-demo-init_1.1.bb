DESCRIPTION = "Init script for qtdemo"
LICENSE = "MIT"
SRC_URI = "file://atmel-qt-demo-init-v${PV}"
PR = "r2"

DEPENDS = "fbset"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

do_install() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/atmel-qt-demo-init-v${PV} ${D}${sysconfdir}/init.d/qtdemo
}

inherit update-rc.d allarch

INITSCRIPT_NAME = "qtdemo"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."
