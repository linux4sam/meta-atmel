FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://github.com/linux4sam/optee_os-at91.git;branch=master;protocol=https"

SRCREV = "9ca99a29b95e7b07c4849d9578dd633a4aed00fb"

OPTEEMACHINE = "sam"

DEPENDS:append = " dtc-native"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd)"
