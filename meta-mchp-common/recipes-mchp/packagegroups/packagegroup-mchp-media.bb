SUMMARY = "A collection of packages focused on video capture and camera interfaces."

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-media \
"

RDEPENDS:packagegroup-mchp-media = "\
    libv4l \
    media-ctl \
    v4l-utils \
    yavta \
"
