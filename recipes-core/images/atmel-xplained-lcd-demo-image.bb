DESCRIPTION = "An image for SAMA5D3 Xplained with screen."
LICENSE = "MIT"
PR = "r1"

require atmel-demo-image.inc

IMAGE_FEATURES += "splash"

IMAGE_INSTALL += "\
    packagegroup-base-usbhost \
    fb-test \
    tslib \
    tslib-conf \
    tslib-tests \
    tslib-calibrate \
    "
