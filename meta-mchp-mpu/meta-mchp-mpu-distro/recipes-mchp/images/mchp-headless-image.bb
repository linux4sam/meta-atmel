DESCRIPTION = "An image for network/communication and image/video capture."
LICENSE = "MIT"
PR = "r1"

COMBINED_FEATURES += "wifi"

require recipes-mchp/images/mchp-base-image.bb

IMAGE_INSTALL += "\
    bluez5 \
    cryptoauthlib \
    kea \
    linuxptp \
    lrzsz \
    ltrace \
    mpg123 \
    mpio \
    python3-cryptoauthlib \
    p11-kit \
    rsync \
    setserial  \
    strace \
    stress-ng \
    systemd-analyze \
"
IMAGE_INSTALL:append:sama5 = "\
    nodejs \
    nodejs-npm \
"
IMAGE_INSTALL:append:sama5d2 = "\
    libv4l \
    media-ctl \
    video-capture-at91 \
    v4l-utils \
    yavta \
"
IMAGE_INSTALL:append:sama5d4 = "\
    g1-decoder \
    gstreamer1.0-plugins-hantro \
"
IMAGE_INSTALL:append:sama5d2-ptc-ek = "ptc-examples"
IMAGE_INSTALL:append:sama5d2-ptc-ek-sd = "ptc-examples"
IMAGE_INSTALL:append:sama5d27-som1-ek-sd = "wilc-demo-fs-overlay"

IMAGE_INSTALL:append:sama5d27-som1-ek-optee-sd = "\
    optee-examples \
    optee-os \
    optee-test \
"
IMAGE_INSTALL:append:sama5d27-wlsom1-ek-sd = "\
    ptc-examples \
    wilc-ble-demo \
    wilc-demo-fs-overlay \
    wilc-websocket-demo \
"
IMAGE_INSTALL:append:sama7g5ek = "\
    bonnie++ \
    fswebcam \
    ffmpeg \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-ugly \
    iozone3 \
    libcamera-mchp \
    libv4l \
    media-ctl \
    video-capture-at91 \
    v4l-utils \
    yavta \
"
IMAGE_INSTALL:append:sama7g5ek-optee-sd = "\
    optee-os \
    optee-test \
    optee-examples \
"
IMAGE_INSTALL:append:sam9x60 = "\
    bonnie++ \
    hostapd \
    wilc-demo-fs-overlay \
"
IMAGE_INSTALL:append:sam9x75 = "\
    ble-bluez-hci-apps \
    bonnie++ \
    ffmpeg \
    fswebcam \
    libcamera-mchp \
    libv4l \
    media-ctl \
    video-capture-at91 \
    v4l-utils \
    wilc-demo-fs-overlay \
    wireless-kit-webpages \
    yavta \
"
