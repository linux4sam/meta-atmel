DESCRIPTION = "Microchip EGT launcher Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"
DEPENDS = "libegt"

RDEPENDS_${PN} = "evtest"

SRC_URI = "git://github.com/linux4sam/egt-launcher.git;protocol=https \
	  file://0001-launch.sh-Use-start-stop-daemon-to-restart-egt.patch"

PV = "1.0+git${SRCPV}"
SRCREV = "1c422c4c90e79dad81784a392cd84f686698cdb4"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

do_configure_prepend() {
	( cd ${S};
	${S}/autogen.sh; cd -)
}

# out-of-tree building doesn't appear to work for this package.
B = "${S}"

FILES_${PN} += " \
    /usr/share/egt/* \
"
