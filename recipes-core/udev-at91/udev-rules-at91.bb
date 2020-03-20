DESCRIPTION = "Extra udev rules for AT91 boards"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = " file://keyboard.rules"

S = "${WORKDIR}"

SRC_URI_append_sama5d2 = " file://ptc.rules"

do_install () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/*.rules ${D}${sysconfdir}/udev/rules.d/
}
