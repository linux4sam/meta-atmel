FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

SRC_URI:append = " \
    file://hostapd@.service \
    file://hostapd.conf \
    file://hostapd_open.conf \
    file://hostapd_wpa.conf \
"

do_configure:append () {
    cp ${WORKDIR}/hostapd.conf ${S}/hostapd/.config
}

do_install:append () {
    install -d ${D}${sysconfdir}/systemd/system
    install -d ${D}${sysconfdir}/network
    install -m 0644 ${WORKDIR}/hostapd@.service ${D}${sysconfdir}/systemd/system
    install -m 0644 ${WORKDIR}/hostapd_open.conf ${D}${sysconfdir}/network
    install -m 0644 ${WORKDIR}/hostapd_wpa.conf ${D}${sysconfdir}/network
}

FILES:{PN}:append = " \
    ${sysconfdir}/systemd/system/ \
    ${sysconfdir}/network/ \
"
