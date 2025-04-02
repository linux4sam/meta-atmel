FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://eth.network \
    file://80-wifi-softap.network.example \
    file://99-custom-system.conf \
"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/ \
    ${sysconfdir}/systemd/system.conf.d/ \
"

do_install:append () {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/eth.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/80-wifi-softap.network.example ${D}${systemd_unitdir}/network
    install -D -m0644 ${WORKDIR}/99-custom-system.conf ${D}${sysconfdir}/systemd/system.conf.d/99-custom-system.conf
}
