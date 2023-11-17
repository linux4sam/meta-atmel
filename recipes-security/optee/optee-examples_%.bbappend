FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "file://0001-Makefile-Fix-non-portable-sh-check-for-plugins.patch"

SRCREV = "378dc0db2d5dd279f58a3b6cb3f78ffd6b165035"

PV = "4.0.0+git${SRCPV}"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd)"
