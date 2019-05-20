require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v3.8.12.tar.gz \
           file://0001-Add-an-option-to-enable-SAM-BA-download.patch \
"

SRC_URI[md5sum] = "9cdcd5b427a7998315e9a0cad4488ffd"
SRC_URI[sha256sum] = "871140177e2cab7eeed572556025f9fdc5e82b2bb18302445d13db0f95e21694"
