DESCRIPTION = "A generic image for network and communication."
LICENSE = "MIT"
PR = "r1"

require recipes-mchp/images/core-image-mchp-base.inc

EXTRA_IMAGE_FEATURES += " \
      tools-debug \
      tools-sdk"

IMAGE_INSTALL:append = "\
    cmake \
    expect \
    glib-2.0 \
    htop \
    libudev \
    rsync \
    polarfire-soc-linux-examples \
    python3-werkzeug \
    sqlite3 \
    zip \
    netcat \
    "
