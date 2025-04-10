FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "e6b19839e65a107ae4832f93bd801c10b3e8c3c5"

PV = "4.5.0+git${SRCPV}"

OPTEEMACHINE = "sam"

DEPENDS:append = " dtc-native"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"
