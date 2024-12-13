FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${LINUX_VERSION}:"

inherit mchp-compat-machines

RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""

# Kernel fragments for specific machines
SRC_URI:append            = " file://userinput.cfg"
SRC_URI:append:sama5      = " file://sama5.cfg"
SRC_URI:append:sama5d2    = " file://greengrass.cfg"
SRC_URI:append:\
sama5d27-som1-ek-optee-sd = " file://sama5-linux-optee.cfg \
                              file://sama5d2/0001-dts-include-optee-dtsi.patch \
                              "
SRC_URI:append:sam9x60    = " file://at91_dt.cfg"
SRC_URI:append:\
sama7g5ek-optee-sd        = " file://sama7g5ek-linux-optee.cfg \
                              file://sama7g5ek/0001-dts-include-optee-dtsi.patch \
                              file://sama7g5ek/0002-ARM-dts-microchip-at91-sama7g5ek-use-scmi0_clock-ins.patch \
                              "

KERNEL_MODULE_AUTOLOAD += "atmel_usba_udc g_serial"
KERNEL_MODULE_AUTOLOAD:append:sama5d27-wlsom1-ek-sd = " wilc-sdio"
