DESCRIPTION = "Microchip QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://COPYING;md5=78a72a436c89c3863a5650347f34a3b3"

PACKAGES = "${PN} ${PN}-dbg"

DEPENDS = "qtbase gstreamer1.0 gstreamer1.0-plugins-hantro g1-decoder libplanes"

RDEPENDS_${PN} = "libplanes"

SRC_URI = "git://github.com/linux4sam/atmel-video-player.git;protcol=https;branch=fixes-qt5.12"
PV = "1.9+git${SRCPV}"
SRCREV = "b3f08f60e57479b290f3de599857ace9012163aa"

S = "${WORKDIR}/git"

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

COMPATIBLE_MACHINE = "sama5d4"

