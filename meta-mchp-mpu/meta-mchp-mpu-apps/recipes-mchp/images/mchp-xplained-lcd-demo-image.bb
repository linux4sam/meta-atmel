DESCRIPTION = "An image for boards with screen and resistive touchscreen."
LICENSE = "MIT"
PR = "r1"

require recipes-mchp/images/mchp-base-image.inc

IMAGE_INSTALL += "\
    packagegroup-mchp-multimedia-audio \
    fb-test \
    libplanes \
    packagegroup-mchp-dev-lua \
    tslib \
    tslib-conf \
    tslib-tests \
    tslib-calibrate \
"
