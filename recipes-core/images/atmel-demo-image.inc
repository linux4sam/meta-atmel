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
    linux-firmware \
    alsa-utils \
    i2c-tools \
    dosfstools \
    libdrm-tests \
    mtd-utils \
    iproute2 \
    iptables \
    bridge-utils \
    canutils \
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

# we don't need the kernel in the image
remove_kernel_rootfs_postprocess() {
    rm -f ${IMAGE_ROOTFS}/boot/*Image*
}

ROOTFS_POSTPROCESS_COMMAND += "remove_kernel_rootfs_postprocess; "

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
