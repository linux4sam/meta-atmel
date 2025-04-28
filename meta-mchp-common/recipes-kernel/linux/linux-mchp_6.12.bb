require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.12.22"
KBRANCH = "linux-6.12-mchp"
SRCREV = "07a63dc1c0e89cbdbabe24a37a2063ae12cb867c"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
