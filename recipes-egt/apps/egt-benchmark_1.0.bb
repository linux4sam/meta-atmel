DESCRIPTION = "Microchip EGT Benchmark Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libegt"

SRC_URI = "git://github.com/linux4sam/egt-benchmark.git;protocol=https"

SRCREV = "304434a09de7e55a5fa4c95f6c5c32d99f60ae63"

S = "${WORKDIR}/git"

inherit pkgconfig autotools-brokensep

EXTRA_OECONF += "--program-prefix='egt_'"

do_configure_prepend() {
	( cd ${S} && ${S}/autogen.sh ) 
}

FILES_${PN} += " \
    ${datadir}/egt/* \
"
