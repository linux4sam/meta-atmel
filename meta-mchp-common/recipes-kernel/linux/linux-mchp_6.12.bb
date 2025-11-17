require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.12.48"
KBRANCH = "linux-6.12-mchp"
SRCREV = "0d1f566d1cac97316b7a493ac6f53e1948a08efd"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
