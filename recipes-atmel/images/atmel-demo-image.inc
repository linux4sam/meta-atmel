IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base-wifi \
    packagegroup-base-bluetooth \
    packagegroup-base-usbgadget \
    kernel-modules \
    lrzsz \
    setserial \
    opkg \
    iperf \
    \
    nbench-byte \
    lmbench \
    \
    linux-firmware \
    atmel-wireless-firmware \
    alsa-utils \
    i2c-tools \
    devmem2 \
    dosfstools \
    libdrm-tests \
    mtd-utils \
    mtd-utils-ubifs \
    dtc \
    dtc-misc \
    iproute2 \
    iptables \
    bridge-utils \
    canutils \
    evtest \
    python-pyserial \
    python-smbus \
    python-ctypes \
    python-pip \
    python-distribute \
    python-pycurl \
    gdbserver \
    usbutils \
    wget \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
