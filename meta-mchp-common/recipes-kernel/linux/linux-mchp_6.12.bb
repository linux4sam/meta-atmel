require linux.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.12.22"
KBRANCH = "linux-6.12-mchp"
SRCREV = "1df6b04aed15d738d00b22309868c335b6898f4e"

SRC_URI = "git://github.com/linux4microchip/linux.git;protocol=https;branch=${KBRANCH}"
