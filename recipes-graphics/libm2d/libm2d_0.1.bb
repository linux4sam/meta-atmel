DESCRIPTION = "Microchip libm2d library for 2DGFX LCD controller"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;endline=20;md5=b0693ac296607eb1fc06d98b63272885"

DEPENDS += "linux-at91 libdrm cairo"

SRC_URI="ftp://at91.com/pub/src/libm2d-sam9x60_2.0.tar.gz;protocol=ftp"

SRC_URI[md5sum] = "7e509aa413e3909a09dffd028965979f"
SRC_URI[sha256sum] = "bb372e70a3d688024fabe0828c6e2e2529b3f7b944a92f829cf035e8611a7ded"

S = "${WORKDIR}"

inherit pkgconfig autotools

FILES_${PN} += " \
	${libdir}/*libm2d*.so* \
	${libdir}/pkgconfig/libm2d.pc \
	${bindir}/blendtest \
	${bindir}/copytest \
	${bindir}/filltest \
	${bindir}/roptest \
	/usr/share/libm2d/* \
	"

FILES_${PN}-dev += " \
	${includedir}/m2d/* \
	${libdir}/libm2d.la \
	"

do_configure_prepend() {
	mkdir -p ${S}/include/drm
	cp ${STAGING_KERNEL_DIR}/include/uapi/drm/atmel_drm.h ${S}/include/drm/atmel_drm.h
	( cd ${S}; ./autogen.sh; cd -)
}

do_install_append() {
	install -Dm 0644 --target-directory=${D}/usr/lib/		${S}/build/src/libm2d.la	
	install -Dm 0644 --target-directory=${D}/usr/include/m2d/	${S}/include/m2d/*
	install -Dm 0644 --target-directory=${D}/usr/lib/pkgconfig/	${S}/build/libm2d.pc
	install -Dm 0644 --target-directory=${D}/usr/lib/		${S}/build/src/.libs/libm2d.so.1.0.0
	install -Dm 0755 --target-directory=${D}/usr/bin/		${S}/build/test/.libs/*
	install -Dm 0644 --target-directory=${D}/usr/share/libm2d/	${S}/test/*.png

	cd ${D}/usr/lib && ln -s -f libm2d.so.1.0.0 libm2d.so.1
	cd ${D}/usr/lib && ln -s -f libm2d.so.1.0.0 libm2d.so
}

COMPATIBLE_MACHINE="sam9x60ek|sam9x60ek-sd"
