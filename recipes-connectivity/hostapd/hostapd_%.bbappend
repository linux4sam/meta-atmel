S = "${WORKDIR}/hostapd-${PV}"

do_configure_append() {
	echo 'CONFIG_SAE=y' >>  ${S}/hostapd/.config
	echo 'CONFIG_DPP=y' >>  ${S}/hostapd/.config
	echo 'CONFIG_OWE=y' >>  ${S}/hostapd/.config
	echo 'CONFIG_IEEE80211W=y' >>  ${S}/hostapd/.config
}
