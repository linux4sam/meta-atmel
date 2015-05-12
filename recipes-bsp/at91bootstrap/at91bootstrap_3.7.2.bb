require at91bootstrap.inc

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
          "
SRC_URI[tarball.md5sum] = "bde892326211cfe739e41edea2f3c5d9"
SRC_URI[tarball.sha256sum] = "c6ee66fc4dc500140633868845d0fb59bd32e010ec886bd7da1af7af06664cfa"
