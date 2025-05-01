FILESEXTRAPATHS:prepend:beaglev-fire := "${THISDIR}/files:"
FILESEXTRAPATHS:prepend:m100pfsevp := "${THISDIR}/files:"

COMPATIBLE_MACHINE:m100pfsevp = "m100pfsevp"
COMPATIBLE_MACHINE:beaglev-fire = "beaglev-fire"

SRC_URI:append:beaglev-fire = "${UBOOT_FILES}"
SRC_URI:append:m100pfsevp = " file://${HSS_PAYLOAD}.yaml"