DESCRIPTION = "Microchip EGT library for sama5 & sam9x lcd controller"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;endline=202;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "\
    libplanes \
    libdrm \
    cairo \
    cjson \
    file \
    fmt \
    udev \
    xxd-native \
"

SRC_URI = "gitsm://github.com/linux4sam/egt.git;protocol=https;branch=1.8"

SRCREV = "4eb1f070c810a3d97209095341ed492bc0267847"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

EXTRA_OECONF += "--disable-debug"

EXTRA_AUTORECONF:append = " -I ${STAGING_DATADIR}/aclocal"

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

FULL_OPTIMIZATION:append = " -Ofast"

do_configure:prepend() {
	rm -rf ${S}/m4/libtool.m4 ${S}/m4/lt*.m4
	( cd ${S} && ${S}/autogen.sh && cd - )
}

# out-of-tree building doesn't appear to work for this package.
B = "${S}"

FILES:${PN} += " \
  ${datadir}/egt/* \
"

#need to delete .a to avoid QA package errors
#deleted audio files to avoid check_data_file_clashes error
do_install:append() {
    rm -f ${D}/usr/lib/libegt.a
    rm -f ${D}/usr/share/egt/examples/audioplayer/*.mp3
    rm -f ${D}/usr/share/egt/examples/drummachine/*.wav
    sed -e 's@[^ ]*-ffile-prefix-map=[^ "]*@@g' \
        -e 's@[^ ]*-fdebug-prefix-map=[^ "]*@@g' \
        -e 's@[^ ]*-fmacro-prefix-map=[^ "]*@@g' \
        -i ${D}${libdir}/pkgconfig/*.pc
}

python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
