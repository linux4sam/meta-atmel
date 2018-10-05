DESCRIPTION = "An image for network and communication."
LICENSE = "MIT"
PR = "r1"

require atmel-demo-image.inc

IMAGE_INSTALL += "\
    packagegroup-base-usbhost \
    mpg123 \
    mpio \
    "

IMAGE_INSTALL_append_sama5d2 = " nodejs nodejs-npm"
IMAGE_INSTALL_append_sama5d3 = " nodejs nodejs-npm"
IMAGE_INSTALL_append_sama5d4 = " nodejs nodejs-npm"

IMAGE_INSTALL_append_sama5d2-ptc-ek = " ptc-examples"
IMAGE_INSTALL_append_sama5d2-ptc-ek-sd = " ptc-examples"
