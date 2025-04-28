FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "02e7f9213b0d7db9c35ebf1e41e733fc9c5a3f75"

DEPENDS:append = " util-linux-libuuid"
inherit pkgconfig

PV = "4.6.0+git${SRCPV}"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"
