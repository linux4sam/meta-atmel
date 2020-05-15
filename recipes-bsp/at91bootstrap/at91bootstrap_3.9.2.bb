require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd|sama5d2-icp-sd|sam9x60ek|sam9x60ek-sd|sama5d27-wlsom1-ek-sd)'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https \
           file://0001-scripts-upgrade-scripts-to-use-Python3.patch \
"

PV = "3.9.2+git${SRCPV}"
SRCREV = "82e9d2512a9e72af50da4f24543a0ae66cacde3d"

S = "${WORKDIR}/git"
