DESCRIPTION = "EGT media files from video demo"
LICENSE = "CLOSED"

PR = "r1"

SRC_URI ="git://github.com/linux4sam/egt-media.git;protocol=https;branch=master"
SRCREV = "7bdb1f492554f7bd1600c0095bab2a75f02a9c71"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-base-alsa \
    gstreamer1.0-plugins-base-playback \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-videoconvertscale \
    gstreamer1.0-plugins-base-volume \
    ${@bb.utils.contains("LICENSE_FLAGS_ACCEPTED", "commercial", "gstreamer1.0-libav", "", d)} \
"

inherit siteinfo

FILES:${PN} += " \
    ${datadir}/egt/examples/video/* \
"

do_install() {
    install -d ${D}/usr/share/egt/examples/video
    cp -Rf ${S}/examples/video/* ${D}//usr/share/egt/examples/video/
}

ALLOW_EMPTY:${PN} = "1"
INHIBIT_DEFAULT_DEPS = "1"

python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}
