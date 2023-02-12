FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:sama5d27-som1-ek-optee-sd = "git://github.com/linux4sam/optee_os-at91.git;branch=master;protocol=https"

SRCREV:sama5d27-som1-ek-optee-sd = "9ca99a29b95e7b07c4849d9578dd633a4aed00fb"

OPTEEMACHINE:sama5d27-som1-ek-optee-sd = "sam"

DEPENDS:append:sama5d27-som1-ek-optee-sd = " dtc-native"

