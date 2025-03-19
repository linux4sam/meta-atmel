FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "d221676a58b305bddbf97db00395205b3038de8e"

DEPENDS:append = " util-linux-libuuid"
inherit pkgconfig

PV = "4.4.0+git${SRCPV}"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"
