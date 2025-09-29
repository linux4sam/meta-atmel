OPTEEMACHINE = "sam"

OPTEE_SUFFIX ?= "bin"
OPTEE_IMAGE ?= "tee-${MACHINE}-${PV}-${PR}.${OPTEE_SUFFIX}"
OPTEE_BINARY ?= "tee.${OPTEE_SUFFIX}"
OPTEE_SYMLINK ?= "tee-${MACHINE}.${OPTEE_SUFFIX}"

OPTEE_PLATFORM_FLAVOR:sama5d27-som1-ek-optee-sd ??="sama5d27_som1_ek"
OPTEE_PLATFORM_FLAVOR:sama7g5ek-optee-sd ??="sama7g54_ek"

EXTRA_OEMAKE += " PLATFORM_FLAVOR=${OPTEE_PLATFORM_FLAVOR} \
                  CFG_NVMEM_HUK=n \
"

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
