FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "6486773583b5983af8250a47cf07eca938e0e422"

DEPENDS:append = " util-linux-libuuid"
inherit pkgconfig

PV = "4.5.0+git${SRCPV}"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"
