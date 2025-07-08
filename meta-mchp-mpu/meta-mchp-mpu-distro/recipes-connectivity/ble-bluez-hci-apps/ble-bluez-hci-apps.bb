SUMMARY = "BlueZ BLE Applications"
DESCRIPTION = "BlueZ BLE UART and DFU Applications"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README;md5=5413bb09d9a7d0e0baa6b9bb69034212"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/linux4microchip/ble_bluez_hci_apps.git;protocol=https;branch=master"
SRCREV  = "01f2dbbdbd5c7d4201a0cb1aa201980d50f670eb"

PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS = "bluez5"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DCMAKE_C_FLAGS='${CMAKE_C_FLAGS} -I${STAGING_INCDIR} -I${STAGING_INCDIR}/bluez5_utils -I${STAGING_INCDIR}/bluez5_utils/src'"
LDFLAGS += "-L${STAGING_LIBDIR}/bluez5_utils/lib"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/apps/ble_uart_app/ble-uart-bluez ${D}${bindir}/
    install -m 0755 ${B}/apps/dfu_app/dfu-bluez ${D}${bindir}/
}

FILES:${PN} = "${bindir}/*"
