DESCRIPTION = "An image that will launch into the demo application for the embedded (not based on X11) version of Qt."
LICENSE = "MIT"
PR = "r0"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL += "\
	packagegroup-core-boot \
	packagegroup-core-basic \
	packagegroup-base-wifi \
	packagegroup-base-bluetooth \
	packagegroup-base-usbgadget \
	openssh-sftp \
	openssh-sftp-server \
	kernel-modules \
	lrzsz \
	setserial \
	opkg \
	iperf \
	\
	nbench-byte \
	lmbench \
	\
	linux-firmware-ralink \
	linux-firmware-ath6k \
	\
	i2c-tools \
	dosfstools \
	mtd-utils \
	iproute2 \
	iptables \
	bridge-utils \
	canutils \
	gdbserver \
	usbutils \
	wget \
	${CORE_IMAGE_BASE_INSTALL} \
	\
	qtbase \
	qtbase-fonts \
	qtbase-plugins \
	qtbase-tools \
	qtmultimedia \
	qtmultimedia-plugins \
	qtmultimedia-qmlplugins \
	qtsvg \
	qtsvg-plugins \
	qtsensors \
	qtsystems \
	qtsystems-tools \
	qtsystems-qmlplugins \
	qtscript \
	qtgraphicaleffects-qmlplugins \
	qtconnectivity-qmlplugins \
	qtlocation-plugins \
	qtlocation-qmlplugins \
	qtdeclarative \
	qtdeclarative-qmlplugins \
	qtdeclarative-plugins \
	\
	libicui18n \
	tslib \
	tslib-calibrate \
	tslib-tests \
	gstreamer1.0 \
	gstreamer1.0-plugins-bad-meta \
	gstreamer1.0-plugins-base-meta \
	gstreamer1.0-plugins-good-meta \
"

inherit core-image

ROOTFS_POSTPROCESS_COMMAND += ""

atmel_qte_rootfs_postprocess() {
    curdir=$PWD
    # remove qtopia extra files
    rm -rf usr/bin/qtopia/demos
    rm -rf usr/bin/qtopia/examples
    rm -rf usr/share/doc
    rm -rf usr/share/qtopia/mkspecs
    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "atmel_qte_rootfs_postprocess;"

sama5d3_xplained_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # autoload needed modules
    cd etc
    echo "atmel_usba_udc" >> modules
    echo "g_serial" >> modules

    cd $curdir
}
