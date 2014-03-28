IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-basic \
    packagegroup-base-wifi \
    packagegroup-base-bluetooth \
    packagegroup-base-usbgadget \
    kernel-modules \
    lrzsz \
    setserial \
    opkg \
    iperf \
    linux-firmware \
    i2c-tools \
    dosfstools \
    mtd-utils \
    iproute2 \
    iptables \
    bridge-utils \
    canutils \
    python-pyserial \
    python-smbus \
    python-ctypes \
    python-pip \
    python-setuptools \
    python-pycurl \
    gdbserver \
    usbutils \
    wget \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image

# we don't need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND += "rm -f ${IMAGE_ROOTFS}/boot/*Image*; "
