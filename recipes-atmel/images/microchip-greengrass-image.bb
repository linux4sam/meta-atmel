DESCRIPTION = "An image with all the packets required for AWS Greengrass"
LICENSE = "MIT"
PR = "r1"

require atmel-demo-image.inc

IMAGE_INSTALL += "\
    packagegroup-base-usbhost \
    mpg123 \
    mpio \
    greengrass \
    "
