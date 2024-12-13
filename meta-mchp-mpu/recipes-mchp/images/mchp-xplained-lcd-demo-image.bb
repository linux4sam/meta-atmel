DESCRIPTION = "An image for boards with screen and resistive touchscreen."
LICENSE = "MIT"
PR = "r1"

require mchp-demo-image.inc

IMAGE_INSTALL += "\
    fb-test \
    libplanes \
    lua-staticdev \
    mpg123 \
    mpio \
    tslib \
    tslib-conf \
    tslib-tests \
    tslib-calibrate \
    "
