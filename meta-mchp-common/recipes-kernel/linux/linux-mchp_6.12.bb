require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.12.22"
KBRANCH = "linux-6.12-mchp"
SRCREV = "a3f1b2b9f50e418ef753d37b359ee22312a25069"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
