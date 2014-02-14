KBRANCH = "linux-3.10-at91"
SRCREV = "83a9eb4b2f16d9b388daa473a954fb2a563a7ccb"
PV = "${LINUX_VERSION}+${SRCREV}"

PR = "r1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/${MACHINE}:"

SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH};nocheckout=1"
SRC_URI += "file://defconfig"

COMPATIBLE_MACHINE = "(sama5d3xek|sama5d3_xplained|at91sam9x5ek|at91sam9rlek)"
