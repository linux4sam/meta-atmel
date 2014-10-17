require at91bootstrap.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "35f4ab2ed71cd3fc13ccf14525e7de2c27348c61"
SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=git \
          "

SRCREV_sama5d4-xplained = "be375331a7971d23f13e6810690c100923e1cc9f"

S = "${WORKDIR}/git"

PV = "3.7+git${SRCPV}"
