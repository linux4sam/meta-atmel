DESCRIPTION = "Microchip EGT library for sama5 & sam9x lcd controller"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

PACKAGES = "\
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
"

DEPENDS = "\
    libplanes \
    libdrm \
    cairo \
    cjson \
    lua \
    libpng \
    jpeg \
    file \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    libxkbcommon \
    libinput \
"

DEPENDS_append_at91sam9 = " tslib"

SRC_URI = "gitsm://bitbucket.microchip.com/scm/linux4sam/egt.git;protocol=https"

SRCREV = "f0e98cc45ecbdcf20c65e65bd3128366087f8715"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

EXTRA_OECONF += " --disable-debug  --enable-examples"

PACKAGECONFIG ??= " librsvg curl"

PACKAGECONFIG[librsvg] = ",,librsvg"
PACKAGECONFIG[curl] = ",,curl"

do_configure_prepend() {
	( cd ${S};
	${S}/autogen.sh; cd -)
}

# out-of-tree building doesn't appear to work for this package.
B = "${S}"

FILES_${PN} += " \
  ${libdir}/* \
  ${includedir}/* \
  ${bindir}/* \
  /usr/share/egt/* \
  /usr/share/libegt/* \
"
INSANE_SKIP_${PN} = "dev-so"

#need to delete .a to avoid QA package errors
do_install_append() {
    rm -f ${D}/usr/lib/libegt.a
}
