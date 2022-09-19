SRC_URI:append:sama5 = " file://atmel_fragment.cfg"
SRC_URI:append:at91sam9 = " file://atmel_fragment.cfg"
SRC_URI:append:sama7 = " file://atmel_fragment.cfg"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

