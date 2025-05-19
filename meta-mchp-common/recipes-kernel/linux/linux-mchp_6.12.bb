require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.12.22"
KBRANCH = "linux-6.12-mchp"
SRCREV = "5f4a0f379bb81aef9fca6cf2da0e416b53a3eef3"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
