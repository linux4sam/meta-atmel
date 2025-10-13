RDEPENDS:${PN}-multimedia += "\
    media-ctl \
    fswebcam \
    v4l-utils \
    gstd \
    gstreamer1.0-plugins-base-videotestsrc \
    gstreamer1.0-plugins-good \
    "

PACKAGES += " \
    ${PN}-multimedia \
"

INSANE_SKIP:${PN}-multimedia += "file-rdeps ldflags debug-files"

EXAMPLE_FILES += "\
    multimedia \
"

FILES:${PN}-multimedia = "/opt/microchip/multimedia/"
