FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

SRC_URI:append = "file://wpa_supplicant.service \
		  file://wpa_supplicant.conf \
		  "

do_configure:append () {
    cp ${WORKDIR}/wpa_supplicant.conf ${S}/wpa_supplicant/.config
}

do_install:append () {
    install -d ${D}${sysconfdir}/systemd/system
    install -m 0644 ${WORKDIR}/wpa_supplicant.service ${D}${sysconfdir}/systemd/system
}

FILES:{PN}:append = " ${sysconfdir}/systemd/system/"
