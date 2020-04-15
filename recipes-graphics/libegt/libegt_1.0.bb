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
    libinput \
    udev \
    xxd-native \
    plplot \
"

DEPENDS_append_at91sam9 = " tslib"

SRC_URI = "gitsm://github.com/linux4sam/egt.git;protocol=https"

SRCREV = "dda99ee3d1ef5ceaeca9061a3b6b8fa0f58beb6b"

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
#deleted audio files to avoid check_data_file_clashes error
do_install_append() {
    rm -f ${D}/usr/lib/libegt.a
    rm -f ${D}/usr/share/egt/examples/audioplayer/*.mp3
    rm -f ${D}/usr/share/egt/examples/drummachine/*.wav
}
