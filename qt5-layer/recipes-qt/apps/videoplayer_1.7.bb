DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://COPYING;md5=78a72a436c89c3863a5650347f34a3b3"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase gstreamer1.0"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/atmel-video-player/archive/master.tar.gz;downloadfilename=atmel-video-player-master.tar.gz"

SRC_URI[md5sum] = "37b0f6bc5cacf7d11c8d7a72c52a5f6f"
SRC_URI[sha256sum] = "8d15198f3176bc171ceac83dd28f737e500f742e9fcfe40234d7a3f13be20c7c"

S = "${WORKDIR}/atmel-video-player-master"

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
