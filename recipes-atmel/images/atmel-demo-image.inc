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
    iperf3 \
    \
    nbench-byte \
    lmbench \
    \
    linux-firmware-sd8686 \
    linux-firmware-sd8688 \
    linux-firmware-sd8787 \
    linux-firmware-sd8797 \
    linux-firmware-sd8801 \
    linux-firmware-sd8887 \
    linux-firmware-sd8897 \
    linux-firmware-ralink \
    linux-firmware-rtl8188 \
    linux-firmware-rtl8723 \
    linux-firmware-rtl8821 \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192su \
    linux-firmware-rtl8723 \
    \
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
    can-utils \
    evtest \
    python-pyserial \
    python-smbus \
    python-ctypes \
    python-pip \
    python-distribute \
    gdbserver \
    usbutils \
    wget \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
