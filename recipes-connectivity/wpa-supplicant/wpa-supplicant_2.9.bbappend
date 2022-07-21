FILESEXTRAPATHS_prepend := "${THISDIR}/wpa_supplicant-${PV}/:"
SRC_URI += "file://0001-nl80211-Register-for-SAE-Authentication-frames-more-.patch \
	file://0002-fix-send_mlme-to-use-monitor-interface-only-for-AP-i.patch"
