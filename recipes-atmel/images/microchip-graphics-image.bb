DESCRIPTION = "An image that will launch into the demo application for the embedded (not based on X11) version of Qt."
LICENSE = "MIT"
PR = "r0"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL += "\
	packagegroup-core-boot \
	packagegroup-core-full-cmdline \
	packagegroup-base-wifi \
	packagegroup-base-bluetooth \
	packagegroup-base-usbhost \
	packagegroup-base-usbgadget \
	openssh-sftp \
	openssh-sftp-server \
	kernel-modules \
	lrzsz \
	setserial \
	opkg \
	iperf3 \
	\
	nbench-byte \
	lmbench \
	\
	linux-firmware-ralink \
	linux-firmware-ath6k \
	mchp-wireless-firmware \
	\
	alsa-utils \
	mpg123 \
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
	python3-pyserial \
	python3-smbus \
	python3-ctypes \
	python3-pip \
	mpio \
	gdb \
	evtest \
	mxt-app \
	usbutils \
	wget \
	dpkg-start-stop \
	${CORE_IMAGE_BASE_INSTALL} \
	\
	cjson \
	lua \
	libplanes \
	\
	libicui18n \
	gstreamer1.0 \
	gstreamer1.0-plugins-bad-meta \
	gstreamer1.0-plugins-base-meta \
	gstreamer1.0-plugins-good-meta \
	gstreamer1.0-plugins-ugly-meta \
	gstreamer1.0-libav \
	libv4l \
	v4l-utils \
	fswebcam \
	ffmpeg \
	\
	liberation-fonts \
	mchp-egt-demo-init \
	hostapd \
	9bit \
	rng-tools \
	bluez5 \
	wireless-regdb-static \
	libdrm \
	net-tools \
	nftables \
	phytool \
	tcpdump \
	dhcp-server \
	dhcp-server-config \
	libegt \
	egt-launcher \
	egt-samples \
	egt-media \
	noto-fonts \
"

IMAGE_INSTALL_append_at91sam9m10g45 = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL_append_at91sam9rl = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL_append_at91sam9x5 = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL_append_at91sam9rl = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL_append_at91sam9x5 = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL_append_sam9x60 = " \
	hostapd \
	bonnie++ \
	libm2d "

IMAGE_INSTALL_append_sama5d2 = " greengrass"

IMAGE_INSTALL_append_sama5d4 = " \
	gstreamer1.0-plugins-hantro \
	g1-decoder \
	"

IMAGE_INSTALL_append_sama5d2-ptc-ek = " ptc-examples"
IMAGE_INSTALL_append_sama5d2-ptc-ek-sd = " ptc-examples"

IMAGE_INSTALL_append_sama5d27-wlsom1-ek-sd = " ptc-examples"

inherit core-image

#TOOLCHAIN_HOST_TASK += "nativesdk-sam-ba"
TOOLCHAIN_HOST_TASK += "nativesdk-swig"
