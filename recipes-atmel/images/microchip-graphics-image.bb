DESCRIPTION = "An image that includes EGT with its demo applications"
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
	libgpiod-tools \
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
	kea \
        ${@oe.utils.conditional('SITEINFO_ENDIANNESS', 'le', 'libegt egt-launcher egt-samples egt-samples-contribution egt-media egt-thermostat egt-benchmark', '', d)} \
	noto-fonts \
	lohit-fonts \
	rsync \
"

IMAGE_INSTALL:append:at91sam9m10g45 = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL:append:at91sam9rl = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL:append:at91sam9x5 = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL:append:at91sam9rl = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL:append:at91sam9x5 = " \
	tslib tslib-conf tslib-tests tslib-calibrate "

IMAGE_INSTALL:append:sam9x60 = " \
	hostapd \
	bonnie++ \
	libm2d "

# packages needed for greengrass with ECC608
IMAGE_INSTALL:append:sama5d2 = " cryptoauthlib python3-cryptoauthlib p11-kit"
IMAGE_INSTALL:append:sama7 = " cryptoauthlib python3-cryptoauthlib p11-kit"

IMAGE_INSTALL:append:sama5d4 = " \
	gstreamer1.0-plugins-hantro \
	g1-decoder \
	"

IMAGE_INSTALL:append:sama5d2-ptc-ek = " ptc-examples"
IMAGE_INSTALL:append:sama5d2-ptc-ek-sd = " ptc-examples"

IMAGE_INSTALL:append:sama5d27-wlsom1-ek-sd = " ptc-examples"

IMAGE_INSTALL:append:sama5d2 = " video-capture-at91 \
				libv4l v4l-utils media-ctl yavta \
				"

inherit core-image siteinfo

TOOLCHAIN_HOST_TASK += "nativesdk-swig"

# Required dependencies to build EGT with the SDK.
TOOLCHAIN_TARGET_TASK += " \
    lua-dev \
    lua-staticdev \
    "
