DESCRIPTION = "An image for network and communication."
LICENSE = "MIT"
PR = "r1"

require atmel-demo-image.inc

IMAGE_INSTALL += "\
    packagegroup-base-usbhost \
    mpg123 \
    mpio \
    rsync \
    linuxptp \
    "

IMAGE_INSTALL:append:sama5d2 = " nodejs nodejs-npm"
IMAGE_INSTALL:append:sama5d3 = " nodejs nodejs-npm"
IMAGE_INSTALL:append:sama5d4 = " nodejs nodejs-npm"

# packages needed for greengrass with ECC608
IMAGE_INSTALL:append:sama5d2 = " cryptoauthlib python3-cryptoauthlib p11-kit"
IMAGE_INSTALL:append:sama7 = " cryptoauthlib python3-cryptoauthlib p11-kit"
IMAGE_INSTALL:append:sam9x60 = " cryptoauthlib python3-cryptoauthlib p11-kit"

IMAGE_INSTALL:append:sama5d2-ptc-ek = " ptc-examples"
IMAGE_INSTALL:append:sama5d2-ptc-ek-sd = " ptc-examples"
IMAGE_INSTALL:append:sama5d27-wlsom1-ek-sd = " ptc-examples nginx \
				wilc-demo-fs-overlay \
				wilc-ble-demo \
				wilc-websocket-demo "

IMAGE_INSTALL:append:sama7g5ek = " bonnie++ iozone3 gstreamer1.0 \
				gstreamer1.0-plugins-base \
				gstreamer1.0-plugins-bad \
				gstreamer1.0-plugins-good \
				gstreamer1.0-plugins-ugly fswebcam ffmpeg \
				libv4l v4l-utils media-ctl libcamera yavta \
				video-capture-at91"

IMAGE_INSTALL:append:sama5d27-som1-ek-optee-sd = " optee-os optee-test optee-examples"

# OSPI image must fit into 120 MBytes
IMAGE_INSTALL:remove:sama7g5ek-ospi = " \
	bonnie++ iozone3 gstreamer1.0 gstreamer1.0-plugins-bad \
	gstreamer1.0-plugins-good gstreamer1.0-plugins-ugly \
	ffmpeg libcamera yavta \
	cryptoauthlib python3-cryptoauthlib p11-kit \
	packagegroup-base-usbhost \
	mpg123 mpio rsync \
	packagegroup-base-bluetooth \
	packagegroup-core-full-cmdline \
	lrzsz \
	opkg \
	iperf3 \
	nbench-byte \
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
	mchp-wireless-firmware \
	alsa-utils \
	libdrm-tests \
	dtc \
	dtc-misc \
	iptables \
	bridge-utils \
	python3-pyserial \
	python3-smbus \
	python3-ctypes \
	python3-pip \
	gdb \
	hostapd \
	9bit \
	bluez5 \
	wireless-regdb-static \
	libdrm \
	net-tools \
	nftables \
	tcpdump \
	kea \
	"

IMAGE_FEATURES:remove:sama7g5ek-ospi = " \
	package-management \
	"
