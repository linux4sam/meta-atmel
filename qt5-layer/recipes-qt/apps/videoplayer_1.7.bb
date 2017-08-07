DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://COPYING;md5=78a72a436c89c3863a5650347f34a3b3"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase gstreamer1.0"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/atmel-video-player/archive/master.tar.gz;downloadfilename=atmel-video-player-master.tar.gz"

SRC_URI[md5sum] = "1311d124ef695a384434576c6c173e92"
SRC_URI[sha256sum] = "60a142e71305ccf96f1de67ed55a65efbe397e89f2b81723a051143c33414ee6"

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
