DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=28;md5=d037302fccdccd4ce1cd367746c5a3bd"

DEFAULT_PREFERENCE = "12"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libv4l"
require recipes-qt/qt5/qt5.inc

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/atmel-video-player-${PV}.tar.gz"

SRC_URI[md5sum] = "b5a9b3bb40cc69d450b8c005b9bb5272"
SRC_URI[sha256sum] = "625b86377fa180c587e529613d7f6afd92ff4c1952338b81a41babb0deabcc91"

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
