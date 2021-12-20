DESCRIPTION = "plplot library"
HOMEPAGE = "http://plplot.org/"
SECTION = "devel"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = " libtool freetype fontconfig cairo pango "

# TAG plplot-5.15.0
SRC_URI = " \
    https://github.com/PLplot/PLplot/archive/refs/tags/${PN}-${PV}.zip;protocol=https \
    file://0001-plplot-fix-configure-error-for-generating-header-fil.patch \
    file://0002-utils-CMakeLists.txt-disable-pltek-build.patch \
    file://0001-xwin.cmake-Check-if-PTHREAD_MUTEX_RECURSIVE_NP-exist.patch \
    file://deltaT.h \
    file://tai-utc.h \
    file://plhershey-unicode.h \
"

SRC_URI[sha256sum] = "2d98caa088a74d4f89e80cf2b347897d79964fd62d0957996a6aea9ca06c99c1"

S = "${WORKDIR}/PLplot-${PN}-${PV}"

EXTRA_OECMAKE += " \
    -DCMAKE_INSTALL_LIBDIR=${libdir} \
    -DCMAKE_INSTALL_INCLUDEDIR=${includedir} \
    -DDEFAULT_NO_BINDINGS=ON \
    -DDEFAULT_NO_CAIRO_DEVICES=OFF \
    -DENABLE_cxx=ON \
    -DNaNAwareCCompiler=ON \
    -DPL_DOUBLE=OFF \
    -DENABLE_DYNDRIVERS:BOOL=OFF \
    -DUSE_RPATH:BOOL=OFF \
    -DCMAKE_NATIVE_BINARY_DIR=${B} \
    -DCMAKE_VERBOSE_MAKEFILE=ON \
"

do_compile_prepend() {
    mkdir -p ${B}/lib/qsastime
    mkdir -p ${B}/include
    cp -avf ${WORKDIR}/deltaT.h  ${B}/lib/qsastime/
    cp -avf ${WORKDIR}/tai-utc.h ${B}/lib/qsastime/
    cp -avf ${WORKDIR}/plhershey-unicode.h ${B}/include/
}

FILES_${PN} = " \
    ${libdir}/* \
    /usr/include/* \
    /usr/share/* \
"

do_install_append() {
    rm -rf ${D}/usr/share/plplot${PV}/examples
}

RDEPENDS_${PN} = " \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
"

inherit cmake pkgconfig
