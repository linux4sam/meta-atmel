DESCRIPTION = "EGT media files from video demo"
LICENSE = "CLOSED"

PR = "r1"

SRC_URI = "https://files.linux4sam.org/pub/demo/media/egt-media-${PV}.tar.gz"

SRC_URI[md5sum] = "c9ddf805e8513847ed1058c267e32737"

S = "${WORKDIR}/examples"

RDEPENDS_${PN} = "gstreamer1.0 \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-base-alsa \
	gstreamer1.0-plugins-base-playback \
	gstreamer1.0-plugins-base-audioconvert \
	gstreamer1.0-plugins-base-audioresample \
	gstreamer1.0-plugins-base-videoscale \
	gstreamer1.0-plugins-base-videoconvert \
	gstreamer1.0-plugins-base-volume \
	${@bb.utils.contains("LICENSE_FLAGS_WHITELIST", "commercial", "gstreamer1.0-libav", "", d)} \
"

FILES_${PN} += " \
    /usr/share/egt/* \
"

do_install() {
	install -d ${D}/usr/share/egt/examples
	cp -Rf ${S}/* ${D}//usr/share/egt/examples/
}

ALLOW_EMPTY_${PN} = "1"
INHIBIT_DEFAULT_DEPS = "1"

python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
