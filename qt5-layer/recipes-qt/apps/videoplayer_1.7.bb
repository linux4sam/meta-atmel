DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://COPYING;md5=78a72a436c89c3863a5650347f34a3b3"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase gstreamer1.0"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/atmel-video-player/archive/v${PV}.tar.gz;downloadfilename=atmel-video-player-${PV}.tar.gz"

SRC_URI[md5sum] = "038a1ef804ec3179b0bcabde8a455c5a"
SRC_URI[sha256sum] = "0756bd558a7cf20207594995897869e8f0b5b812b7b1ff0d4519107294c697a5"

S = "${WORKDIR}/atmel-video-player-${PV}"

inherit pkgconfig

PACKAGES = "${PN}-dbg ${PN}"
FILES_${PN}-dbg = " \
  /opt/VideoPlayer/.debug \
  /usr/* \
"

FILES_${PN} = " \
	/opt/VideoPlayer/player \
	/opt/VideoPlayer/Video-Player.sh \
	/opt/VideoPlayer/Player.sh \
	/opt/VideoPlayer/media/* \
	/opt/ApplicationL* \
	"

do_install() {
	make INSTALL_ROOT=${D} install
	cp ${B}/player ${D}/opt/VideoPlayer/
	cp ${S}/Video-Player.sh ${D}/opt/VideoPlayer/
	cp ${S}/Player.sh ${D}/opt/VideoPlayer/
	cp -rf ${S}/med* ${D}/opt/VideoPlayer/
}
