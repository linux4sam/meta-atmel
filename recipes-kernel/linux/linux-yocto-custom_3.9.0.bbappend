FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
COMPATIBLE_MACHINE_sama5d3xek = "at91sama5d3xek"
COMPATIBLE_MACHINE_at91sam9x5ek = "at91sam9x5ek"
SRC_URI += " file://${MACHINE}/${KBRANCH}/meta-atmel-${KBRANCH}.scc \
    "

# Increment the recipe revision
PRINC := "${@int(PRINC) + 1}"
