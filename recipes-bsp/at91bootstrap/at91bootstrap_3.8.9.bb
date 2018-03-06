require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
	file://Add_-fno-builtin_to_CPPFLAGS_for_gcc7.patch \
"

SRC_URI[tarball.md5sum] = "3d2eb156c1683b815f0752b68bbac489"
SRC_URI[tarball.sha256sum] = "df6e126b439044e8d5b89816f66f05472c5cd5847c63a0796ef50d56a1a577f7"
