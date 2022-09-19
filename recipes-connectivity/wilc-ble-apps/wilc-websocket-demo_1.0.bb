SUMMARY = "WLAN Application to provision WILC via HTTP Web page"
DESCRIPTION = "The example is to demonstrate HTTP Web based provisioning, \
	the recipe contains a TCP socket based application which will let \
	the NGINX hosted webpage to add the router credentials to 	  \
	wpa_supplicant.conf and thereby enables the device to connect to  \
	configured router it in the STA mode."

AUTHOR = "Microchip Technology Inc"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=e24bfdbf6035afa17b105dc86b249d9f"
DEPENDS = "nginx"
SRC_URI = "git://github.com/MicrochipTech/websocket-buildroot-external-microchip.git;protocol=https;branch=master"
PV = "1.0+git${SRCPV}"
SRCREV = "dccae5ea9b0710d4331a5a1f9f56764141b99117"

S = "${WORKDIR}/git"

do_compile () {
	${TARGET_PREFIX}gcc ${TARGET_CC_ARCH} ${TOOLCHAIN_OPTIONS} -Wall  \
	-std=gnu11 -g -D_REENTRANT -static ${S}/websocket_control.c 	  \
	${WORKDIR}/git/websocket_protocol.c -o websocket
}

do_install () {
    install -D -m 0755 --target-directory=${D}${ROOT_HOME} ${B}/websocket
}

FILES:${PN} += "${ROOT_HOME}"

COMPATIBLE_MACHINE = "(at91sam9|sama5)"
