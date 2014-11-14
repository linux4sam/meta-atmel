DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=28;md5=d037302fccdccd4ce1cd367746c5a3bd"

DEFAULT_PREFERENCE = "12"
PR = "r1"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libv4l"
require recipes-qt/qt5/qt5.inc

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/atmel-video-player-${PV}.tar.gz"

SRC_URI[md5sum] = "c682bd9ca2661624311f1d139e4ba213"
SRC_URI[sha256sum] = "426d91502408e4a02e7196b4ce1bef5e47f2100fb0f20ef3b817c92978a1ab7a"

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
