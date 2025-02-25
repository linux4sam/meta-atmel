require u-boot-atmel.inc
require u-boot-envs-atmel.inc

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=22;md5=b5410c33378a67de244a5877f9ff9a27"

SRCREV = "ad869b2ab2b0d7779b8cc6dd5a3c554cd4aa16a3"

PV = "v2024.07-mchp+git${SRCPV}"

DEPENDS += "coreutils-native bison-native flex-native"

COMPATIBLE_MACHINE = '(at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek\
|sama5d2-icp-sd\
|sama5d2-ptc-ek|sama5d2-ptc-ek-sd\
|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc\
|sama5d27-som1-ek|sama5d27-som1-ek-sd|sama5d27-som1-ek-optee-sd\
|sama5d27-wlsom1-ek-sd\
|sama5d29-curiosity-sd\
|sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd\
|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd\
|sama7g5ek|sama7g5ek-optee-sd\
|sam9x60ek|sam9x60ek-sd\
|sam9x60-curiosity|sam9x60-curiosity-sd\
|sam9x75-curiosity|sam9x75-curiosity-sd\
|sam9x75eb|sam9x75eb-sd\
|sama7d65-curiosity|sama7d65-curiosity-sd\
)'

UBRANCH = "u-boot-2024.07-mchp"

SRC_URI = "git://github.com/linux4microchip/u-boot-mchp.git;protocol=https;branch=${UBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
