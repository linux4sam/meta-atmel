FILESEXTRAPATHS:prepend := "${THISDIR}/wpa_supplicant-${PV}/:"

PACKAGECONFIG ??= "openssl"

do_configure:append() {
	echo 'CONFIG_SAE=y' >>  wpa_supplicant/.config
	echo 'CONFIG_DPP=y' >>  wpa_supplicant/.config
	echo 'CONFIG_OWE=y' >>  wpa_supplicant/.config
	echo 'CONFIG_IEEE80211W=y' >>  wpa_supplicant/.config
}
