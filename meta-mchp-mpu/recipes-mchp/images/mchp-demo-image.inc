require ../meta-mchp-common/recipes-mchp/images/core-image-mchp-base.inc

MACHINE_FEATURES += "serial"

IMAGE_INSTALL += "\
    9bit \
    alsa-utils \
    libdrm \
    libdrm-tests \
    packagegroup-base-bluetooth \
    packagegroup-base-usbgadget \
    packagegroup-base-usbhost \
    packagegroup-base-wifi \
    mchp-wireless-firmware \
    "
