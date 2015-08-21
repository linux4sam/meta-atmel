require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d2-xplained)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
          "
SRC_URI[tarball.md5sum] = "f7c1b54eba91677469a818b995a85661"
SRC_URI[tarball.sha256sum] = "f87a20833b8e13bf559b1a8b560b6d52a6248d85856c18896957e94866e3afd2"
