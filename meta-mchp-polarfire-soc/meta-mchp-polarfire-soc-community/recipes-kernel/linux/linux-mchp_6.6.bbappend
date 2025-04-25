FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:m100pfsevp = " file://m100pfsevp_configs.cfg"

COMPATIBLE_MACHINE:m100pfsevp = "m100pfsevp"
COMPATIBLE_MACHINE:beaglev-fire = "beaglev-fire"
