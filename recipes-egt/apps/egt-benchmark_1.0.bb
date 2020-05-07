DESCRIPTION = "Microchip EGT Benchmark Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libegt"

SRC_URI = "git://github.com/linux4sam/egt-benchmark.git;protocol=https \
           file://0001-configure-Do-not-add-C-compiler-flags-to-CPPFLAGS.patch \
          "

SRCREV = "e20643eb2c6165e34dc52edbba488616a3aaae22"

S = "${WORKDIR}/git"

inherit pkgconfig autotools-brokensep

EXTRA_OECONF += "--program-prefix='egt_'"

do_configure_prepend() {
	( cd ${S} && ${S}/autogen.sh ) 
}

FILES_${PN} += " \
    ${datadir}/egt/* \
"
