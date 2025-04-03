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
    cjson \
    dpkg-start-stop \
    fswebcam \
    ffmpeg \
    gstreamer1.0 \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-ugly-meta \
    gstreamer1.0-libav \
    liberation-fonts \
    libicui18n \
    libplanes \
    libv4l \
    lohit-fonts \
    lua \
    mchp-egt-demo-init \
    mchp-wireless-firmware \
    mxt-app \
    noto-fonts \
    openssh-sftp \
    openssh-sftp-server \
    usbutils \
    v4l-utils \
    ${@oe.utils.conditional('SITEINFO_ENDIANNESS', 'le', 'libegt egt-launcher egt-samples egt-samples-contribution egt-media egt-thermostat egt-benchmark', '', d)} \
"
