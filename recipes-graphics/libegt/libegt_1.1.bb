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
    file \
    udev \
    xxd-native \
"

SRC_URI = "gitsm://github.com/linux4sam/egt.git;protocol=https"

SRCREV = "276a2f9f295e327c8a0749f385565619f6510a7f"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

EXTRA_OECONF += "--disable-debug"

PACKAGECONFIG ??= "examples icons plplot curl librsvg gstreamer jpeg zlib libinput lua ${@bb.utils.filter('DISTRO_FEATURES', 'x11 alsa', d)}"

PACKAGECONFIG[librsvg] = "--with-librsvg,-without-librsvg,librsvg"
PACKAGECONFIG[curl] = "--with-libcurl,--without-libcurl,curl"
PACKAGECONFIG[examples] = "--enable-examples,--disable-examples"
PACKAGECONFIG[icons] = "--enable-icons,--disable-icons"
PACKAGECONFIG[plplot] = "--with-plplot,--without-plplot,plplot"
PACKAGECONFIG[gstreamer] = "--with-gstreamer,--without-gstreamer,gstreamer1.0 gstreamer1.0-plugins-base"
PACKAGECONFIG[libevdev] = ",,libevdev"
PACKAGECONFIG[jpeg] = "--with-libjpeg,--without-libjpeg,jpeg"
PACKAGECONFIG[tslib] = "--with-tslib,--without-tslib,tslib"
PACKAGECONFIG[alsa] = "--with-alsa,--without-alsa,alsa-lib"
PACKAGECONFIG[libsndfile] = "--with-sndfile,--without-sndfile,libsndfile1"
PACKAGECONFIG[zlib] = "--with-zlib,--without-zlib,zlib"
PACKAGECONFIG[libinput] = "--with-libinput,--without-libinput,libinput"
PACKAGECONFIG[lua] = "--with-lua,--without-lua,lua"
PACKAGECONFIG[xkbcommon] = "--with-xkbcommon,--without-xkbcommon,libxkbcommon"
PACKAGECONFIG[x11] = "--with-x11,--without-x11,libx11"

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

python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
