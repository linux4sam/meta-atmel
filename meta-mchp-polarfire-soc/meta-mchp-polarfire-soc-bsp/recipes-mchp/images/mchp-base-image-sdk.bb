DESCRIPTION = "Microchip base image with software development tools"
LICENSE = "MIT"

require recipes-mchp/images/mchp-base-image.bb

IMAGE_INSTALL:append = "\
    packagegroup-core-sdk \
    packagegroup-core-standalone-sdk-target \
    packagegroup-core-tools-debug \
"
