require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.12.48"
KBRANCH = "linux-6.12-mchp"
SRCREV = "eed0a6f4a0e1b403c99906c49bdabb547e4b23fe"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
