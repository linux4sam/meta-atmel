KBRANCH = "linux-3.10-at91"
SRCREV = "ea25eb8a3ac9fcebc6c0d3b1c8e0c1223684d331"
PV = "${LINUX_VERSION}+${SRCREV}"

PR = "r4"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/${MACHINE}:"

SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH};nocheckout=1"
SRC_URI += "file://defconfig"

COMPATIBLE_MACHINE = "(sama5d3xek|sama5d3_xplained|at91sam9x5ek|at91sam9rlek)"
