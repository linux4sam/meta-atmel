FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

OPTEEMACHINE = "sam"

DEPENDS:append = " dtc-native"

SRC_URI = "git://github.com/linux4sam/optee_os-at91.git;branch=master;protocol=https"

SRCREV = "bab2c0cf717ebb2d4b70ab82ec534d0b1e13415e"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd)"

OPTEE_SUFFIX ?= "bin"
OPTEE_IMAGE ?= "tee-${MACHINE}-${PV}-${PR}.${OPTEE_SUFFIX}"
OPTEE_BINARY ?= "tee.${OPTEE_SUFFIX}"
OPTEE_SYMLINK ?= "tee-${MACHINE}.${OPTEE_SUFFIX}"

do_install:append() {
    #install core in boot
    install -d ${D}/boot
    install -m 644 ${B}/core/*.bin ${B}/core/tee.elf ${D}/boot/
    install ${B}/core/${OPTEE_BINARY} ${D}/boot/${OPTEE_IMAGE}
    ln -sf ${OPTEE_IMAGE} ${D}/boot/${OPTEE_BINARY}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy:append() {
    install -d ${DEPLOYDIR}
    install -m 644 ${D}/boot/* ${DEPLOYDIR}/
    install ${B}/core/${OPTEE_BINARY} ${DEPLOYDIR}/${OPTEE_IMAGE}

    cd ${DEPLOYDIR}
    rm -f ${OPTEE_BINARY} ${OPTEE_SYMLINK}
    ln -sf ${OPTEE_IMAGE} ${OPTEE_SYMLINK}
    ln -sf ${OPTEE_IMAGE} ${OPTEE_BINARY}
}

SYSROOT_DIRS += "/boot/"

FILES:${PN} += "/boot/"
FILESPATH =. "${FILE_DIRNAME}/optee-os/${MACHINE}:"
