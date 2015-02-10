# icu is required to build qtwebkit (unicode support)
PACKAGECONFIG_DEFAULT += "no-xcb icu tslib linuxfb openssl"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://atmel-color-format-force.patch"
