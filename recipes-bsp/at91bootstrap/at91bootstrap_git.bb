require at91bootstrap.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=git \
          "
S = "${WORKDIR}/git"

PV = "3.8+git${SRCPV}"

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"
