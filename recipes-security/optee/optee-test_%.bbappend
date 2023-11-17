FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " openssl"

SRCREV = "1c3d6be5eaa6174e3dbabf60928d15628e39b994"

PV = "4.0.0+git${SRCPV}"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd)"
