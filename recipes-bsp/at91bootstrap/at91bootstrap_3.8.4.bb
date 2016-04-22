require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
          "
SRC_URI[tarball.md5sum] = "b99a614f0b0da975463717aa06e8d444"
SRC_URI[tarball.sha256sum] = "00b0e2367007acef6e74531e32e691b88c9b2677fa652f7d908b2b57de280d58"
