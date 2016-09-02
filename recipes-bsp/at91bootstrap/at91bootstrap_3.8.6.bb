require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
"

SRC_URI[tarball.md5sum] = "fcc8a314c9a8f00aff0ad56fac52b73e"
SRC_URI[tarball.sha256sum] = "a2e9ec6f42ee3b5a805fe215257b63070b6c498d57c568c46fcb18fd1b38ea7e"
