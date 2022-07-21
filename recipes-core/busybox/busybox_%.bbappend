SRC_URI:append_sama5 = " file://atmel_fragment.cfg"
SRC_URI:append_at91sam9 = " file://atmel_fragment.cfg"
SRC_URI:append_sama7 = " file://atmel_fragment.cfg"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

