DESCRIPTION = "Microchip libm2d library for 2DGFX LCD controller"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;endline=20;md5=b0693ac296607eb1fc06d98b63272885"

DEPENDS += "linux-mchp libdrm"

SRC_URI = "git://github.com/linux4sam/libm2d.git;protocol=https;branch=master"

SRCREV = "923e28dfe68690085905a1d9d1695cddb56c3ef8"

S = "${WORKDIR}/git"

PV = "1.0+git${SRCPV}"

PACKAGECONFIG ??= ""
PACKAGECONFIG[cairo] = "--enable-cairo,--disable-cairo"

inherit pkgconfig autotools

FILES:${PN} += " \
	${libdir}/*libm2d*.so* \
	${libdir}/pkgconfig/libm2d.pc \
	${bindir}/blendtest \
	${bindir}/copytest \
	${bindir}/filltest \
	${bindir}/roptest \
	/usr/share/libm2d/* \
	"

FILES:${PN}-dev += " \
	${includedir}/m2d/* \
	${libdir}/libm2d.la \
	"

do_configure:prepend() {
	mkdir -p ${S}/include/drm
	cp ${STAGING_KERNEL_DIR}/include/uapi/drm/atmel_drm.h ${S}/include/drm/atmel_drm.h
	( cd ${S}; ./autogen.sh; cd -)
}

do_install:append() {
	install -Dm 0644 --target-directory=${D}/usr/lib/		${B}/src/libm2d.la
	install -Dm 0644 --target-directory=${D}/usr/include/m2d/	${S}/include/m2d/*
	install -Dm 0644 --target-directory=${D}/usr/lib/pkgconfig/	${B}/libm2d.pc
	install -Dm 0644 --target-directory=${D}/usr/lib/		${B}/src/.libs/libm2d.so.1.0.0
	install -Dm 0755 --target-directory=${D}/usr/bin/		${B}/test/.libs/*
	install -Dm 0644 --target-directory=${D}/usr/share/libm2d/	${S}/test/*.png

	cd ${D}/usr/lib && ln -s -f libm2d.so.1.0.0 libm2d.so.1
	cd ${D}/usr/lib && ln -s -f libm2d.so.1.0.0 libm2d.so
}

COMPATIBLE_MACHINE="sam9x60"
