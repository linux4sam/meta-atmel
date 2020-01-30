DESCRIPTION = "Demo apps for SAMA5 9-bit / Multidrop Serial Mode"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbe63b61f5a0d24e651c8be602a7c3f8"

SRC_URI = "git://github.com/linux4sam/9bit.git;protocol=https \
           file://0001-include-asm-generic-ioctls.h.patch \
          "

PV = "1.0+git${SRCPV}"
SRCREV = "f4cd916c8c58300ea1cbb398f0b40fe43a70d6d6"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 senda_example ${D}${bindir}
    install -m 0755 p9bit_example ${D}${bindir}
    install -m 0755 user_example ${D}${bindir}
}

