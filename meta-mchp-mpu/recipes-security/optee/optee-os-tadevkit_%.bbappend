FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "8f645256efc0dc66bd5c118778b0b50c44469ae1"

PV = "4.4.0+git${SRCPV}"

OPTEEMACHINE = "sam"

DEPENDS:append = " dtc-native"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"
