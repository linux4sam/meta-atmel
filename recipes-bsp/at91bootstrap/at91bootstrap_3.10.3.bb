require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd|sama5d2-icp-sd|sam9x60ek|sam9x60ek-sd|sama5d27-wlsom1-ek-sd|sama7g5ek)'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https;branch=at91bootstrap-3.x"

PV = "3.10.3+git${SRCPV}"
SRCREV = "fcc51f8ddb4bb346debf1960f8ba04387169ecc0"

S = "${WORKDIR}/git"

AT91BOOTSTRAP_BIN_PATH = "${S}/binaries"

AT91BOOTSTRAP_CONFIG_PATH = "${S}/board/${AT91BOOTSTRAP_MACHINE}"
