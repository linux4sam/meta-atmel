require at91bootstrap.inc

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
          "
SRC_URI[tarball.md5sum] = "8030f57bd742b7300ef41c78d4a310e0"
SRC_URI[tarball.sha256sum] = "3f475b011e48acbd90181482b088be8b3f87cfe7ee452ce26c1bec22849d997d"
