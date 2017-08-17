require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-bsr|sama5d2-xplained-bsr-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
"

SRC_URI[tarball.md5sum] = "0fe09464681a4416338df624e7840a31"
SRC_URI[tarball.sha256sum] = "ac4eb3706cce2fdb4994b1ec917695bcb2fb132a0336daf2a7eef9c1a053f936"
