require linux.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
PV = "5.15+git${SRCPV}"

KBRANCH = "linux-5.15-mchp"
SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
SRCREV = "865f0c8411a759c2d43239b97217abd7d0eb21e5"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# Add greengrass fragment for SAMA5D2 platforms
SRC_URI_append_sama5d2 = "\
    file://gg.cfg \
"
KERNEL_MODULE_AUTOLOAD_append_sama5d27-wlsom1-ek-sd = " wilc-sdio"

COMPATIBLE_MACHINE = "(sam9x60ek|sama5d27-som1-ek|sama5d27-wlsom1-ek-sd|sama5d2-icp-sd|sama7g5ek)"
