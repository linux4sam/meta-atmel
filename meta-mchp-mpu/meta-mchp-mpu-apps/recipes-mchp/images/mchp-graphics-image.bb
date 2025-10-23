DESCRIPTION = "An image that includes EGT with its demo applications"
LICENSE = "MIT"
PR = "r0"

require mchp-headless-image.bb

inherit siteinfo

TOOLCHAIN_HOST_TASK += "nativesdk-swig"

# Required dependencies to build EGT with the SDK.
TOOLCHAIN_TARGET_TASK += "\
    lua-dev \
    lua-staticdev \
    libstdc++-dev \
"

IMAGE_INSTALL:append = "\
    ${@oe.utils.conditional('SITEINFO_ENDIANNESS', 'le', 'libegt egt-launcher egt-samples egt-samples-contribution egt-media egt-thermostat egt-benchmark', '', d)} \
    liberation-fonts \
    libplanes \
    libsndfile1 \
    lohit-fonts \
    noto-fonts \
    packagegroup-mchp-egt-apps \
    packagegroup-mchp-graphics \
    packagegroup-mchp-multimedia \
    packagegroup-mchp-multimedia-camera \
    packagegroup-mchp-multimedia-gstreamer \
    usbutils \
"
