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

IMAGE_INSTALL += "\
    alsa-utils \
    cjson \
    dpkg-start-stop \
    ffmpeg \
    liberation-fonts \
    libicui18n \
    libsndfile1 \
    libv4l \
    lohit-fonts \
    lua \
    mchp-wireless-firmware \
    mxt-app \
    noto-fonts \
    openssh-sftp \
    openssh-sftp-server \
    usbutils \
    v4l-utils \
"
