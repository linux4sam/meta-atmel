DESCRIPTION = "Microchip EGT Theroststat Demo Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"
DEPENDS = " libegt"

SRC_URI = "git://github.com/linux4sam/egt-thermostat.git;protocol=https"

SRCREV = "04295306df254ac623336d56ca9440b40be76dc8"

S = "${WORKDIR}/git"

# out-of-tree building doesn't appear to work for this package.
B = "${S}"

inherit pkgconfig autotools gettext

do_configure_prepend() {
	( cd ${S};
	${S}/autogen.sh; cd -)
}

FILES_${PN} += " \
    /usr/share/egt/* \
"
