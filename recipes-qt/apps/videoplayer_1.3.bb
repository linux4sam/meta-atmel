DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=28;md5=d037302fccdccd4ce1cd367746c5a3bd"

DEFAULT_PREFERENCE = "12"
PR = "r1"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libv4l"
require recipes-qt/qt5/qt5.inc

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/atmel-video-player-${PV}.tar.gz"

SRC_URI[md5sum] = "890092275cc4e97d333c3f1564b4bf3c"
SRC_URI[sha256sum] = "bd242552cc8612e1b1609915b0983ec110f5606eaa10e167739776e9dbe68c40"

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
