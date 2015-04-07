require at91bootstrap.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=git \
          "
S = "${WORKDIR}/git"

PV = "3.7+git${SRCPV}"
