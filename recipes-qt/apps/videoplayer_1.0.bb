DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=7d42c13f2673e5f36453489810e05ec2"

DEFAULT_PREFERENCE = "12"
PR = "r1"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libv4l"
require recipes-qt/qt5/qt5.inc

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/atmel-video-player-${PV}.tar.gz"

SRC_URI[md5sum] = "c69240b0e3a0119bb33654442673ab35"
SRC_URI[sha256sum] = "d0312cdae37af78d4a11a02619623282012f8934e81995afb42bae8310bcd2f8"

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
        /opt/ApplicationL* \
	"

do_install() {
	make INSTALL_ROOT=${D} install
	cp ${S}/../build/player ${D}/opt/VideoPlayer/
}
