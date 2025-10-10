DESCRIPTION = "An image for network/communication and image/video capture."
LICENSE = "MIT"
PR = "r1"

COMBINED_FEATURES += "wifi"

require recipes-mchp/images/mchp-base-image.bb

IMAGE_INSTALL:append = "\
    packagegroup-base-bluetooth \
    packagegroup-base-usbgadget \
    packagegroup-base-usbhost \
    packagegroup-base-wifi \
    packagegroup-mchp-multimedia-audio \
"

IMAGE_INSTALL:append:sam9x75 = "\
    packagegroup-mchp-multimedia \
    packagegroup-mchp-multimedia-camera \
    video-capture-at91 \
"

IMAGE_INSTALL:append:sama5 = "\
    packagegroup-mchp-dev-nodejs \
"

IMAGE_INSTALL:append:sama7g5ek = "\
    packagegroup-mchp-multimedia \
    packagegroup-mchp-multimedia-camera \
    packagegroup-mchp-multimedia-gstreamer \
    video-capture-at91 \
"

IMAGE_INSTALL:append:sama5d2 = "\
    packagegroup-mchp-multimedia-camera \
    video-capture-at91 \
"
