DESCRIPTION = "An image for network and communication."
LICENSE = "MIT"
PR = "r1"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-basic \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    opkg \
    iperf \
    wpa-supplicant \
    wireless-tools \
    linux-firmware \
    i2c-tools \
    dosfstools \
    mtd-utils \
    iproute2 \
    iptables \
    bridge-utils \
    canutils \
    python-pyserial \
    python-ctypes \
    "

inherit core-image

