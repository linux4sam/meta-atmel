FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:${THISDIR}/files:"
COMPATIBLE_MACHINE_sama5d3xek = "sama5d3xek"
COMPATIBLE_MACHINE_at91sam9x5ek = "at91sam9x5ek"
RREPLACES_${PN} = "kernel-image-3.6.9-yocto-standard"
RCONFLICTS_${PN} = "kernel-image-3.6.9-yocto-standard"
SRC_URI_append_at91sam9x5ek += "file://${MACHINE}/${KBRANCH}/UBI_config.cfg \
    file://${MACHINE}/${KBRANCH}/0001-AT91-rtc-Enable-RTC-in-device-tree.patch \ 
    file://${MACHINE}/${KBRANCH}/0002-AT91-usart-Add-USART3-to-AT91SAM9x5-device-tree.patch \ 
    "
    
# Increment the recipe revision
PRINC := "${@int(PRINC) + 2}"

