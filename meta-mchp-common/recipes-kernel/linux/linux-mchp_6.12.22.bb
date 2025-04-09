require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.12.22"
KBRANCH = "linux-6.12-mchp"
SRCREV = "924495c558b85f1d0025c10ee0fd09a68eb9730a"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
