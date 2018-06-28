DESCRIPTION = "Microchip QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://COPYING;md5=78a72a436c89c3863a5650347f34a3b3"

PACKAGES = "${PN} ${PN}-dbg"

DEPENDS = "qtbase gstreamer1.0 gstreamer1.0-plugins-hantro g1-decoder libplanes"

RDEPENDS_${PN} = "libplanes"

SRC_URI = "https://github.com/linux4sam/atmel-video-player/archive/v${PV}.tar.gz;downloadfilename=atmel-video-player-${PV}.tar.gz"


SRC_URI[md5sum] = "e27d1ed7343cae6f20536de7b0277d3b"
SRC_URI[sha256sum] = "ae216ea4ad8f3af8611844d5da9505afd129ad16eb09c0c2ae76d95f8bf6324f"

S = "${WORKDIR}/atmel-video-player-${PV}"

inherit qmake5 pkgconfig

FILES_${PN}-dbg = " \
	/opt/VideoPlayer/.debug \
	/usr/* \
"

#/usr/lib/libplanes.so.0
FILES_${PN} = " \
	/opt/VideoPlayer/player \
	/opt/VideoPlayer/Player.sh \
	/opt/VideoPlayer/screen.config \
	/opt/VideoPlayer/media/* \
	/opt/ApplicationL* \
	/usr/* \
"

do_install() {
	make INSTALL_ROOT=${D} install
	cp ${B}/player ${D}/opt/VideoPlayer/
	cp -rf ${S}/med* ${D}/opt/VideoPlayer/
	cp ${S}/Player.sh ${D}/opt/VideoPlayer/
}
