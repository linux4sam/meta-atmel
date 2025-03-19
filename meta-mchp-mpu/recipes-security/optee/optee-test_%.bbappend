FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " openssl"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=a8fa504109e4cd7ea575bc49ea4be560"

SRC_URI:remove = "file://0001-xtest-stats-remove-unneeded-stat.h-include.patch"

SRCREV = "695231ef8987866663a9ed5afd8f77d1bae3dc08"

PV = "4.4.0+git${SRCPV}"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"
