DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://COPYING;md5=78a72a436c89c3863a5650347f34a3b3"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase gstreamer1.0"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/atmel-video-player/archive/v${PV}.tar.gz"

S = "${WORKDIR}/atmel-video-player-${PV}"

inherit pkgconfig

PACKAGES = "${PN}-dbg ${PN}"
FILES_${PN}-dbg = " \
  /opt/VideoPlayer/.debug \
  /usr/* \
"

FILES_${PN} = " \
	/opt/VideoPlayer/player \
	/opt/VideoPlayer/Atmel-Video-Player.sh \
	/opt/VideoPlayer/med* \
        /opt/ApplicationL* \
	"

do_install() {
	make INSTALL_ROOT=${D} install
	cp ${B}/player ${D}/opt/VideoPlayer/
}
