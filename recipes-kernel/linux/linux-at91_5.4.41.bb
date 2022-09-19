require linux.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${P}:"
PV = "5.4+git${SRCPV}"

KBRANCH = "sama7g5_early"
SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=https;branch=${KBRANCH}"
SRCREV = "d67f0979dcc377863060e803a2280b7a7e1a22c0"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

COMPATIBLE_MACHINE = "(sama7g5ek)"
