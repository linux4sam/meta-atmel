require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.6.51"
KBRANCH = "linux-6.6-mchp"
SRCREV = "171ac7ce6392ce4584590b5d148b03e01e8f9e53"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
