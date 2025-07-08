FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:sama5 = " file://mchp_fragment.cfg"
SRC_URI:append:at91sam9 = " file://mchp_fragment.cfg"
SRC_URI:append:sama7 = " file://mchp_fragment.cfg"
