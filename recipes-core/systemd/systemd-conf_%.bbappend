FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://eth.network \
     file://wlan.network \
"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/eth.network \
     ${sysconfdir}/systemd/network/wlan.network \
"

do_install () {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/eth.network ${D}${sysconfdir}/systemd/network
     install -m 0644 ${WORKDIR}/wlan.network ${D}${sysconfdir}/systemd/network
}
