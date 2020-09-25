require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama7g5ek-sd)'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https"

PV = "3.10.0+git${SRCPV}"
SRCREV = "b6b0ecebb9ef737ae59528e24066a26b1f7c8f23"

S = "${WORKDIR}/git"
