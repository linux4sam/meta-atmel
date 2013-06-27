FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
COMPATIBLE_MACHINE_sama5d3xek = "at91sama5d3xek"
COMPATIBLE_MACHINE_at91sam9x5ek = "at91sam9x5ek"
SRC_URI_append_at91sam9x5ek += "file://${MACHINE}/${KBRANCH}/UBI_config.cfg \
    file://${MACHINE}/${KBRANCH}/rtc.patch \
    file://${MACHINE}/${KBRANCH}/usart3.patch \
    file://${MACHINE}/${KBRANCH}/usb-c.patch \
    "
    
# Increment the recipe revision
PRINC := "${@int(PRINC) + 1}"
