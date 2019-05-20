DESCRIPTION = "Demo apps for SAMA5 9-bit / Multidrop Serial Mode"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbe63b61f5a0d24e651c8be602a7c3f8"

SRC_URI = "git://github.com/linux4sam/9bit.git;protocol=https"

PV = "1.0+git${SRCPV}"
SRCREV = "df45b743003a78bb735eb3c2cb294f3cce3ae43a"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}${bindir}
    install senda_example ${D}${bindir}
    install p9bit_example ${D}${bindir}
    install user_example ${D}${bindir}
}

