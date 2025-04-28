FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "file://0001-Makefile-Fix-non-portable-sh-check-for-plugins.patch"

SRCREV = "5306d2c7c618bb4a91df17a2d5d79ae4701af4a3"

PV = "4.6.0+git${SRCPV}"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"
