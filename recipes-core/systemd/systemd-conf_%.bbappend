FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://eth.network \
    file://wlan.network \
    file://99-custom-system.conf \
"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/ \
    ${sysconfdir}/systemd/system.conf.d/ \
"

do_install:append () {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/eth.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wlan.network ${D}${sysconfdir}/systemd/network
    install -D -m0644 ${WORKDIR}/99-custom-system.conf ${D}${sysconfdir}/systemd/system.conf.d/99-custom-system.conf
}
