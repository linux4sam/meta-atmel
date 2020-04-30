DESCRIPTION = "Microchip EGT Benchmark Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libegt"

SRC_URI = "git://github.com/linux4sam/egt-benchmark.git;protocol=https"

SRCREV = "b585c1f12271b4fd1f17cec2b75661846ddff0f4"

S = "${WORKDIR}/git"

B = "${S}"

inherit pkgconfig autotools

EXTRA_OECONF += "--program-prefix='egt_'"

do_configure_prepend() {
	( cd ${S};
	${S}/autogen.sh; cd -)
}

FILES_${PN} += " \
    ${datadir}/egt/* \
"
