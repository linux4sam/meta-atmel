inherit core-image

IMAGE_FEATURES += "ssh-server-openssh package-management debug-tweaks"

WIFI_FIRMWARE_PACKAGES = "\
    linux-firmware-ralink \
    linux-firmware-rtl8188 \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    linux-firmware-rtl8723 \
    linux-firmware-rtl8821 \
    linux-firmware-sd8686 \
    linux-firmware-sd8688 \
    linux-firmware-sd8787 \
    linux-firmware-sd8797 \
    linux-firmware-sd8801 \
    linux-firmware-sd8887 \
    linux-firmware-sd8897 \
    "

IMAGE_INSTALL += "\
    bridge-utils \
    can-utils \
    devmem2 \
    dosfstools \
    dtc \
    dtc-misc \
    evtest \
    gdb \
    hostapd \
    i2c-tools \
    iperf3 \
    iproute2 \
    iptables \
    kernel-modules \
    libgpiod-tools \
    lmbench \
    mtd-utils \
    mtd-utils-ubifs \
    nbench-byte \
    nftables \
    opkg \
    packagegroup-base \
    packagegroup-core-full-cmdline \
    phytool \
    python3-ctypes \
    python3-pip \
    python3-pyserial \
    python3-smbus \
    rng-tools \
    tcpdump \
    wget \
    ${@bb.utils.contains('COMBINED_FEATURES', 'wifi', WIFI_FIRMWARE_PACKAGES, '', d)} \
    "
