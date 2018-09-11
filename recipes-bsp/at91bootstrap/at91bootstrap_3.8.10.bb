require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball;downloadfilename=${PN}-${PV}.tar.gz \
"

S = "${WORKDIR}/${PN}-${PV}"

SRC_URI[tarball.md5sum] = "b36ddc2d62d2a7db069e366b939fac4d"
SRC_URI[tarball.sha256sum] = "0e868265e9f71b6a742ed97851c9944bb7179c232ded61ea3ec226db46b6507a"
