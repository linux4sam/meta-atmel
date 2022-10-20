FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://github.com/linux4sam/optee_os-at91.git;branch=master;protocol=https"

SRCREV = "bab2c0cf717ebb2d4b70ab82ec534d0b1e13415e"

OPTEEMACHINE = "sam"

DEPENDS:append = " dtc-native"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd)"
