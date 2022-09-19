require linux.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${P}:"
PV = "5.15+git${SRCPV}"

KBRANCH = "linux-5.15-mchp"
SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
SRC_URI:append:sam9x60 = " file://defconfig"
SRC_URI:append:sama5 = " file://defconfig"
SRCREV = "839c6e99b0ec12b2a1daca093d6553ad0c2991e0"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# Add greengrass fragment for SAMA5D2 platforms
SRC_URI:append:sama5d2 = "\
    file://gg.cfg \
"
KERNEL_MODULE_AUTOLOAD:append:sama5d27-wlsom1-ek-sd = " wilc-sdio"

COMPATIBLE_MACHINE = "(sam9x60ek|sama5d27-som1-ek|sama5d27-wlsom1-ek-sd|sama5d2-icp-sd|sama7g5ek|sam9x60-curiosity)"
