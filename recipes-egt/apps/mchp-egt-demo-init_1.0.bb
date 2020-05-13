DESCRIPTION = "Init script for EGT launcher demo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "file://S99egtdemo \
	"

RDEPENDS_${PN} = "udev-rules-at91"

PR = "r2"

do_install() {
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/profile.d/
	install -m 0755 ${WORKDIR}/S99egtdemo  ${D}${sysconfdir}/init.d/egtdemo
}

inherit update-rc.d allarch

INITSCRIPT_NAME = "egtdemo"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."
