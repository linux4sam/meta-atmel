FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

OPTEEMACHINE:sama5d27-som1-ek-optee-sd = "sam"

DEPENDS:append:sama5d27-som1-ek-optee-sd = " dtc-native"

SRC_URI:sama5d27-som1-ek-optee-sd = "git://github.com/linux4sam/optee_os-at91.git;branch=master;protocol=https"

SRCREV:sama5d27-som1-ek-optee-sd = "9ca99a29b95e7b07c4849d9578dd633a4aed00fb"

OPTEE_SUFFIX:sama5d27-som1-ek-optee-sd ?= "bin"
OPTEE_IMAGE:sama5d27-som1-ek-optee-sd ?= "tee-${MACHINE}-${PV}-${PR}.${OPTEE_SUFFIX}"
OPTEE_BINARY:sama5d27-som1-ek-optee-sd ?= "tee.${OPTEE_SUFFIX}"
OPTEE_SYMLINK:sama5d27-som1-ek-optee-sd ?= "tee-${MACHINE}.${OPTEE_SUFFIX}"

do_install:append:sama5d27-som1-ek-optee-sd() {
    #install core in boot
    install -d ${D}/boot
    install -m 644 ${B}/core/*.bin ${B}/core/tee.elf ${D}/boot/
    install ${B}/core/${OPTEE_BINARY} ${D}/boot/${OPTEE_IMAGE}
    ln -sf ${OPTEE_IMAGE} ${D}/boot/${OPTEE_BINARY}
}

do_deploy:append:sama5d27-som1-ek-optee-sd() {
    install -d ${DEPLOYDIR}
    install -m 644 ${D}/boot/* ${DEPLOYDIR}/
    install ${B}/core/${OPTEE_BINARY} ${DEPLOYDIR}/${OPTEE_IMAGE}

    cd ${DEPLOYDIR}
    rm -f ${OPTEE_BINARY} ${OPTEE_SYMLINK}
    ln -sf ${OPTEE_IMAGE} ${OPTEE_SYMLINK}
    ln -sf ${OPTEE_IMAGE} ${OPTEE_BINARY}
}

SYSROOT_DIRS:append:sama5d27-som1-ek-optee-sd = " /boot/"

FILES:${PN} += "/boot/"
FILESPATH =. "${FILE_DIRNAME}/optee-os/${MACHINE}:"
