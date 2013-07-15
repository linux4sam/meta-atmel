FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
COMPATIBLE_MACHINE_sama5d3xek = "sama5d3xek"
COMPATIBLE_MACHINE_at91sam9x5ek = "at91sam9x5ek"
SRCREV="linux-3.6.9-at91"
SRC_URI_append_at91sam9x5ek += "file://at91sam9x5ek/UBI_config.cfg"

