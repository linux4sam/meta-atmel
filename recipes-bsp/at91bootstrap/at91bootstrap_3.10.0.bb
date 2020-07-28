require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama7g5ek-sd)'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https"

PV = "3.10.0+git${SRCPV}"
SRCREV = "83cbe2ea456e55afd1e145b25e3875d0bef17d17"

S = "${WORKDIR}/git"
