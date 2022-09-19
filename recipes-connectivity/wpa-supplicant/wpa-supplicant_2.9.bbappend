FILESEXTRAPATHS:prepend := "${THISDIR}/wpa_supplicant-${PV}/:"
SRC_URI += "file://0001-nl80211-Register-for-SAE-Authentication-frames-more-.patch \
	file://0002-fix-send_mlme-to-use-monitor-interface-only-for-AP-i.patch"

PACKAGECONFIG ??= "openssl"

do_configure:append() {
	echo 'CONFIG_SAE=y' >>  wpa_supplicant/.config
	echo 'CONFIG_DPP=y' >>  wpa_supplicant/.config
	echo 'CONFIG_OWE=y' >>  wpa_supplicant/.config
	echo 'CONFIG_IEEE80211W=y' >>  wpa_supplicant/.config
}
