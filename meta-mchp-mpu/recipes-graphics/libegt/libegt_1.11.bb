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
DEPENDS:append:sam9x60 = " libm2d"
DEPENDS:append:sam9x75 = " libm2d"

SRC_URI = "gitsm://github.com/linux4sam/egt.git;protocol=https;branch=1.11"

SRCREV = "3af246022cb431a4edb567fb1fe5bed0233a003a"

S = "${WORKDIR}/git"

inherit pkgconfig cmake gettext

PACKAGECONFIG ??= "tslib examples icons plplot curl librsvg gstreamer jpeg zlib libinput lua ${@bb.utils.filter('DISTRO_FEATURES', 'x11 alsa', d)}"

PACKAGECONFIG[librsvg] = "-DWITH_LIBRSVG=ON,-DWITH_LIBRSVG=OFF,librsvg"
PACKAGECONFIG[curl] = "-DWITH_LIBCURL=ON,-DWITH-LIBCURL=OFF,curl"
PACKAGECONFIG[examples] = "-DENABLE_EXAMPLES=ON,-DENABLE_EXAMPLES=OFF"
PACKAGECONFIG[icons] = "-DENABLE_ICONS=ON,-DENABLE_ICONS=OFF"
PACKAGECONFIG[plplot] = "-DWITH_PLPLOT=ON,-DWITH_PLPLOT=OFF,plplot"
PACKAGECONFIG[gstreamer] = "-DWITH_GSTREAMER=ON,-DWITH_GSTREAMER=OFF,gstreamer1.0 gstreamer1.0-plugins-base"
PACKAGECONFIG[libevdev] = ",,libevdev"
PACKAGECONFIG[jpeg] = "-DWITH_LIBJPEG=ON,-DWITH_LIBJPEG=OFF,jpeg"
PACKAGECONFIG[tslib] = "-DWITH_TSLIB=ON,-DWITH_TSLIB=OFF,tslib"
PACKAGECONFIG[alsa] = "-DWITH_ALSA=ON,-DWITH_ALSA=OFF,alsa-lib"
PACKAGECONFIG[zlib] = "-DWITH_ZLIB=ON,-DWITH_ZLIB=OFF,zlib"
PACKAGECONFIG[libinput] = "-DWITH_LIBINPUT=ON,-DWITH_LIBINPUT=OFF,libinput"
PACKAGECONFIG[lua] = "-DWITH_LUA=ON,-DWITH_LUA=OFF,lua"
PACKAGECONFIG[xkbcommon] = "-DWITH_XKBCOMMON=ON,-DWITH_XKBCOMMON=OFF,libxkbcommon"
PACKAGECONFIG[x11] = "-DWITH_X11=ON,-DWITH_X11=OFF,libx11"

FULL_OPTIMIZATION:append = " -Ofast"

FILES:${PN} += " \
  ${datadir}/egt/* \
"

do_install:append() {
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
