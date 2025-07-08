FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

PACKAGECONFIG:mpuall ??= "openssl"

SRC_URI:append:mpuall = "file://wpa_supplicant.service"

do_configure:append:mpuall () {
    cat <<EOF >> wpa_supplicant/.config
CONFIG_SAE=y
CONFIG_DPP=y
CONFIG_OWE=y
CONFIG_IEEE80211W=y
EOF
}

do_install:append:mpuall () {
    install -d ${D}${sysconfdir}/systemd/system
    install -m 0644 ${WORKDIR}/wpa_supplicant.service ${D}${sysconfdir}/systemd/system
}

FILES:{PN}:append:mpuall = " ${sysconfdir}/systemd/system/"
