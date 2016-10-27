DESCRIPTION = "An image that will launch into the demo application for the embedded (not based on X11) version of Qt."
LICENSE = "MIT"
PR = "r0"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL += "\
	packagegroup-core-boot \
	packagegroup-core-full-cmdline \
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
	atmel-wireless-firmware \
	\
	alsa-utils \
	i2c-tools \
	devmem2 \
	dosfstools \
	libdrm-tests \
	mtd-utils \
	dtc \
	dtc-misc \
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
	evtest \
	mxt-app \
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
	qtserialport \
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
	qtquick1 \
	qtquick1-qmlplugins \
	qtquick1-plugins \
	qtwebkit \
	qtwebkit-qmlplugins \
	\
	libicui18n \
	gstreamer1.0 \
	gstreamer1.0-plugins-bad-meta \
	gstreamer1.0-plugins-base-meta \
	gstreamer1.0-plugins-good-meta \
	gstreamer1.0-plugins-ugly-meta \
	gstreamer1.0-libav \
	libv4l \
	\
	homeautomation \
	smartrefrigerator \
	applicationlauncher \
	qmlbrowser \
	samegame \
	minehunt \
	videoplayer \
	ptpdemo \
	atmel-qt-demo-init \
"

IMAGE_INSTALL_append_at91sam9 = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL_append_sama5d4 = " \
	gstreamer1.0-plugins-hantro \
	g1-binaries-dev \
	g1-binaries-staticdev \
	"
inherit core-image populate_sdk_qt5

#TOOLCHAIN_HOST_TASK += "nativesdk-sam-ba"
