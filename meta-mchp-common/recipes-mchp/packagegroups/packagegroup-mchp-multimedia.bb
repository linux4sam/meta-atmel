SUMMARY = "A set of tools for audio/video playback, encoding, decoding, and streaming"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-multimedia \
    packagegroup-mchp-multimedia-audio \
    packagegroup-mchp-multimedia-gstreamer \
"

RDEPENDS:packagegroup-mchp-multimedia = "\
    ${@bb.utils.contains("LICENSE_FLAGS_ACCEPTED", "commercial", "ffmpeg", "", d)} \
"

RDEPENDS:packagegroup-mchp-multimedia-audio = "\
    alsa-utils \
    mpg123 \
"

RDEPENDS:packagegroup-mchp-multimedia-gstreamer = "\
    gstreamer1.0 \
    ${@bb.utils.contains("LICENSE_FLAGS_ACCEPTED", "commercial", "gstreamer1.0-libav", "", d)} \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    ${@bb.utils.contains("LICENSE_FLAGS_ACCEPTED", "commercial", "gstreamer1.0-plugins-ugly", "", d)} \
"
