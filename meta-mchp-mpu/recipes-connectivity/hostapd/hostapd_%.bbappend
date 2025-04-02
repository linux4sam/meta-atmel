FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

S = "${WORKDIR}/hostapd-${PV}"

SRC_URI:append = " \
    file://hostapd@.service \
    file://wilc_hostapd_open.conf \
    file://wilc_hostapd_wpa.conf \
"

do_configure:append() {
    cat <<EOF >> ${S}/hostapd/.config
CONFIG_SAE=y
CONFIG_DPP=y
CONFIG_OWE=y
CONFIG_IEEE80211W=y
EOF
}

do_install:append () {
    install -d ${D}${sysconfdir}/systemd/system
    install -d ${D}${sysconfdir}/network
    install -m 0644 ${WORKDIR}/hostapd@.service ${D}${sysconfdir}/systemd/system
    install -m 0644 ${WORKDIR}/wilc_hostapd_open.conf ${D}${sysconfdir}/network
    install -m 0644 ${WORKDIR}/wilc_hostapd_wpa.conf ${D}${sysconfdir}/network
}

FILES:${PN} += " \
    ${sysconfdir}/systemd/system/ \
    ${sysconfdir}/network/ \
"
