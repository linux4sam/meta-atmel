require videoplayer.inc

SRC_URI += "file://Video-Player.sh \
		    file://Player.sh \
"

SRC_URI[md5sum] = "2dd80028d55ccddca8dec30d2d37c7fd"
SRC_URI[sha256sum] = "a5fd62e33f965ebc3a5a251cc4005a20253ab9bb9e0211c4f810d105c471fe54"

FILES_${PN} += "\
	/opt/VideoPlayer/Video-Player.sh \
	/opt/VideoPlayer/Player.sh \
	"

do_install_append() {
	cp -rf ${WORKDIR}/Video-Player.sh ${D}/opt/VideoPlayer/
	cp -rf ${WORKDIR}/Player.sh ${D}/opt/VideoPlayer/
}

