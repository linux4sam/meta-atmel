FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

SRC_URI:append = "\
    file://kea-dhcp4.conf \
    "

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "kea-dhcp4.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install:append () {
    install -d ${D}${sysconfdir}/kea
    install -m 0644 ${WORKDIR}/kea-dhcp4.conf ${D}${sysconfdir}/kea/kea-dhcp4.conf
}

FILES:${PN} += " \
    ${systemd_unitdir}/system/kea-* \
"
