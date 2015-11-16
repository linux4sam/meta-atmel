require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d2-xplained)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
          "
SRC_URI[tarball.md5sum] = "5af0f0857fd9425f2aeb53b19b7bb616"
SRC_URI[tarball.sha256sum] = "7e252ac43b239bef1732fa9069b76c166a9c100cf307f229a7b53688849ea824"
