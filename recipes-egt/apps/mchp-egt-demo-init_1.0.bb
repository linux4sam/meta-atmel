DESCRIPTION = "Init script for EGT launcher demo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "file://egtdemo.service"

RDEPENDS:${PN} = "udev-rules-at91"

PR = "r2"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/egtdemo.service ${D}${systemd_unitdir}/system/
}

inherit allarch systemd
FILES:${PN} += "${systemd_unitdir}/system/"

SYSTEMD_SERVICE:${PN} = "egtdemo.service"
