SUMMARY = "Bluetooth Connectivity Application"
DESCRIPTION = "The example is to demonstrate BLE provisioning and BLE 	\
	Transparent Services.						\
	the application is written using the BlueZ GATT service and it	\
	enables the WILC to host two GATT services,		 	\
	1) transparent service 2) WiFi provisioning service 		\
	The Microchip MBD application can be used to connect to WILC	\
	and transact BLE data through these BLE applications"

AUTHOR = "Microchip Technology Inc"
SECTION = "examples"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=2aadfbb30f3dc663d0c881ccb240fc4c"

DEPENDS = "bluez5 wilc-demo-fs-overlay"
SRC_URI = "git://github.com/MicrochipTech/wilcbtapps-buildroot-external-microchip.git;protocol=https;branch=master"
PV = "1.0+git${SRCPV}"
SRCREV  = "9a3003d8c28da803bb0f621f888a643a0a0a7f76"

S = "${WORKDIR}/git"

do_compile () {
        ${TARGET_PREFIX}gcc ${TARGET_CC_ARCH} ${TOOLCHAIN_OPTIONS} -Wall    \
	-std=gnu11 -g -D_REENTRANT -static -I${STAGING_INCDIR}/bluez5_utils \
        -L ${STAGING_LIBDIR}/bluez5_utils/lib transparent_service.c	    \
	-o transparent_service -lshared-mainloop -lbluetooth-internal	    \
	-lgdbus-internal -lc

        ${TARGET_PREFIX}gcc ${TARGET_CC_ARCH} ${TOOLCHAIN_OPTIONS} -Wall    \
	-std=gnu11 -g -D_REENTRANT -static -I${STAGING_INCDIR}/bluez5_utils \
	-L ${STAGING_LIBDIR}/bluez5_utils/lib wifi_prov_service.c	    \
	-o wifi_prov_service -lshared-mainloop -lbluetooth-internal 	    \
	-lgdbus-internal -lc
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 transparent_service ${D}${bindir}
    install -m 0755 wifi_prov_service ${D}${bindir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += "${bindir}/transparent_service"
FILES:${PN} += "${bindir}/wifi_prov_service"

COMPATIBLE_MACHINE = "(at91sam9|sama5)"
