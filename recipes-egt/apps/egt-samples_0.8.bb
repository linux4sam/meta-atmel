DESCRIPTION = "Microchip EGT Theroststat Demo Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"
DEPENDS = " libegt"

SRC_URI = "gitsm://github.com/linux4sam/egt-samples.git;protocol=https \
	   file://0001-fix-the-builf-error-of-Cannot-use-CP_USE_DOUBLES-on-.patch "

PV = "0.8+git${SRCPV}"
SRCREV = "584b43ab845708ba79bdb8e2fb14af188f94a395"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

do_configure_prepend() {
     ( cd ${S}; ${S}/autogen.sh; cd -)
}

FILES_${PN} += " \
    /usr/share/egt/* \
"
# out-of-tree building doesn't appear to work for this package.
B = "${S}"

EXTRA_OECONF = "--program-prefix='egt_'"
