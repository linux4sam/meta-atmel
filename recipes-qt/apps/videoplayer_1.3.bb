DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=28;md5=d037302fccdccd4ce1cd367746c5a3bd"

DEFAULT_PREFERENCE = "12"
PR = "r1"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libv4l"
inherit qmake5

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/atmel-video-player-${PV}.tar.gz"

SRC_URI_sama5d4-xplained = " \
           ftp://ftp.linux4sam.org/pub/demo/qtdemo/atmel-video-player-${PV}.tar.gz \
           file://videoplayer-480x272-resolution-support.patch \
           file://videoplayer-change-to-PLAN_B-version.patch \
          "

SRC_URI[md5sum] = "cd57c0846bb4af9677c891085e50f363"
SRC_URI[sha256sum] = "0f660bc0bbb6ddefddd52cd95c05096500c94ff36dddaa67d58629392ccbe1a6"

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
