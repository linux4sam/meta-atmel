require linux.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
PV = "5.15+git${SRCPV}"

KBRANCH = "linux-5.15-mchp"
SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
SRCREV = "b3879eccd66460d772fd860270a0ffddc5116010"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

COMPATIBLE_MACHINE = "(sama7g5ek)"
