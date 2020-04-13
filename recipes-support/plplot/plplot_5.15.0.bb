DESCRIPTION = "plplot library"
HOMEPAGE = "http://plplot.org/"
SECTION = "devel"

LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://Copyright;endline=285;md5=9222bd6b5e4e128fac952e168cffc361"

DEPENDS = " libtool freetype fontconfig cairo pango "

BUILDTAG="plplot-5.15.0"

SRC_URI = "git://git.code.sf.net/p/plplot/plplot;protocol=https;tag=${BUILDTAG} \
    file://0001-plplot-fix-configure-error-for-generating-header-fil.patch \
    file://0002-utils-CMakeLists.txt-disable-pltek-build.patch \
    file://0001-xwin.cmake-Check-if-PTHREAD_MUTEX_RECURSIVE_NP-exist.patch \
    file://deltaT.h \
    file://tai-utc.h \
    file://plhershey-unicode.h \
"

S = "${WORKDIR}/git"

B = "${WORKDIR}/build"

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

inherit cmake pkgconfig
