DESCRIPTION = "Microchip EGT launcher Application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"
DEPENDS = "libegt"

SRC_URI = "git://github.com/linux4sam/egt-launcher.git;protocol=https \
	  file://0001-launch.sh-Use-start-stop-daemon-to-restart-egt.patch"

SRCREV = "b583f4a1b92a84ce8aa83ac970304caf85406dc6"

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
