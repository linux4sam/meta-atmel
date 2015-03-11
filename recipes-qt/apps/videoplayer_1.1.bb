DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=7d42c13f2673e5f36453489810e05ec2"

DEFAULT_PREFERENCE = "12"
PR = "r1"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libv4l"
inherit qmake5

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/atmel-video-player-${PV}.tar.gz"

SRC_URI[md5sum] = "364500ca0e5792fa8e71c437aa652dc4"
SRC_URI[sha256sum] = "5c9bd6facc95ac4d47105b986ea6476c719961189a74425630d6684da3ed7760"

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
	cp ${B}/player ${D}/opt/VideoPlayer/
}
