DESCRIPTION = "Microchip EGT Benchmark Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libegt"

SRC_URI = "git://github.com/linux4sam/egt-benchmark.git;protocol=https"

SRCREV = "be25417177e874d1a665705a86dfaa25458f64ac"

S = "${WORKDIR}/git"

inherit pkgconfig autotools-brokensep

EXTRA_OECONF += "--program-prefix='egt_'"

do_configure_prepend() {
	( cd ${S} && ${S}/autogen.sh ) 
}

FILES_${PN} += " \
    ${datadir}/egt/* \
"
