require at91bootstrap.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "${AUTOREV}"
SRC_URI = "${@bb.utils.contains('BB_NO_NETWORK', '1', '', 'git://github.com/linux4sam/at91bootstrap.git;protocol=git', d)}"

S = "${WORKDIR}/git"

PV = "3.8+git${SRCPV}"

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd|sama5d2-icp-sd)'
