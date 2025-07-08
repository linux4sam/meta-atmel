FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "71785645fa6ce42db40dbf5a54e0eaedc4f61591"

PV = "4.6.0+git${SRCPV}"

OPTEEMACHINE = "sam"

DEPENDS:append = " dtc-native"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"
