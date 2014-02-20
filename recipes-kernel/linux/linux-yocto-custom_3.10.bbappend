KBRANCH = "linux-3.10-at91"
SRCREV = "c43e663f3f933921467e5a03ca9887390156746a"
PV = "${LINUX_VERSION}+${SRCREV}"

PR = "r2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/${MACHINE}:"

SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH};nocheckout=1"
SRC_URI += "file://defconfig"

COMPATIBLE_MACHINE = "(sama5d3xek|sama5d3_xplained|at91sam9x5ek|at91sam9rlek)"
