DESCRIPTION = "An image for boards with screen and resistive touchscreen."
LICENSE = "MIT"
PR = "r1"

require atmel-demo-image.inc

IMAGE_INSTALL += "\
    packagegroup-base-usbhost \
    mpg123 \
    mpio \
    lua-staticdev \
    libplanes \
    fb-test \
    tslib \
    tslib-conf \
    tslib-tests \
    tslib-calibrate \
    "
