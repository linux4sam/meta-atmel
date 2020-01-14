require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = 'sama5d2-icp-sd'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https \
"

PV = "3.9.1+git${SRCPV}"
SRCREV = "2a5f7f8464f631d8095c24ac1e5e8fc32e93c284"

S = "${WORKDIR}/git"
