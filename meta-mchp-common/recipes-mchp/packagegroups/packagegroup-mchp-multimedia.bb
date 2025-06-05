SUMMARY = "A set of tools for audio/video playback, encoding, decoding, and streaming"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-multimedia \
    packagegroup-mchp-multimedia-gstreamer \
"

RDEPENDS:packagegroup-mchp-multimedia = "\
    alsa-utils \
    ffmpeg \
"

RDEPENDS:packagegroup-mchp-multimedia-gstreamer = "\
    gstreamer1.0 \
    gstreamer1.0-libav \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-ugly \
"
