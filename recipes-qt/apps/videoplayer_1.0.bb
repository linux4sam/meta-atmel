DESCRIPTION = "Atmel QT video player demo"
LICENSE = "ATMEL_LLA"
LIC_FILES_CHKSUM = "file://main.cpp;endline=146;md5=7d42c13f2673e5f36453489810e05ec2"

PR = "r2"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase libv4l"
inherit qmake5

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/atmel-video-player-${PV}.tar.gz"

SRC_URI[md5sum] = "75d5a295bedc348eb2f598e95d8a8170"
SRC_URI[sha256sum] = "cda081a655a8b34fe5f09f64285df95a57ec61fed399933dd77310281ba4fd5d"

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
