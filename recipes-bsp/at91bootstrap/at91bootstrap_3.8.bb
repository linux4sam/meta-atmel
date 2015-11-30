require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d2-xplained)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
          "
SRC_URI[tarball.md5sum] = "9caf44c60f2c3186f1f05b807bb09a67"
SRC_URI[tarball.sha256sum] = "ae7bb3f8e631f5216f05fd4650b37f2e76d88d0b893bd680f4f398f33b8f3470"
