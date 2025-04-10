require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.6.64"
KBRANCH = "linux-6.6-mchp"
SRCREV = "c05aab8dd660eeefd3b959b535d6296120761240"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
