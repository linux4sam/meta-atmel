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

# Unified usba_udc and g_serial
module_autoload_atmel_usba_udc = "atmel_usba_udc"
module_autoload_g_serial = "g_serial"

sama5d3_xplained_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # autoload needed modules
    cd etc
    echo "atmel_usba_udc" >> modules
    echo "g_serial" >> modules

    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "sama5d3_xplained_rootfs_postprocess; "
