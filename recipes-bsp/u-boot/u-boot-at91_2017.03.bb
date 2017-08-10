require u-boot-atmel.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=22;md5=2687c5ebfd9cb284491c3204b726ea29"

SRCREV = "1512c0fd32988dea65ae271c847a8f7dd0216e31"

PV = "v2017.03-at91+git${SRCPV}"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd)'

UBRANCH = "u-boot-2017.03-at91"
SRC_URI = "git://github.com/linux4sam/u-boot-at91.git;branch=${UBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
