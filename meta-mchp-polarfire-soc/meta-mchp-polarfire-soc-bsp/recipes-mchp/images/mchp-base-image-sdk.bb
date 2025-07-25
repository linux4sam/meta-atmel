DESCRIPTION = "Microchip base image with software development tools"
LICENSE = "MIT"

require recipes-mchp/images/mchp-base-image.inc

IMAGE_INSTALL:append = "\
    packagegroup-mchp-apps \
    packagegroup-mchp-security \
    packagegroup-core-sdk \
    packagegroup-core-standalone-sdk-target \
    packagegroup-core-tools-debug \
"
