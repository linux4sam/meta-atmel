require at91bootstrap.inc

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
           file://Remove-standard-includes.patch \
           file://Creating-symlink-to-binary.patch \
          "
SRC_URI[tarball.md5sum] = "ba7db33c8af101e3415a6125f2878eb1"
SRC_URI[tarball.sha256sum] = "0ffbdbca2a921faac0a87abe0362f4368fdb2e2a447e185be418f831e51eac23"
