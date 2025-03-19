FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

OPTEEMACHINE = "sam"

DEPENDS:append = " dtc-native python3-cryptography-native"

SRCREV = "8f645256efc0dc66bd5c118778b0b50c44469ae1"

SRC_URI:append = " file://0001-plat-sam-remove-NVMEM_HUK.patch \
		   file://0001-drivers-clk-sam-extend-the-time-for-waiting-PLL-read.patch \
		   "

PV = "4.4.0+git${SRCPV}"

COMPATIBLE_MACHINE = "(sama5d27-som1-ek-optee-sd|sama7g5ek-optee-sd)"

OPTEE_SUFFIX ?= "bin"
OPTEE_IMAGE ?= "tee-${MACHINE}-${PV}-${PR}.${OPTEE_SUFFIX}"
OPTEE_BINARY ?= "tee.${OPTEE_SUFFIX}"
OPTEE_SYMLINK ?= "tee-${MACHINE}.${OPTEE_SUFFIX}"

OPTEE_PLATFORM_FLAVOR:sama5d27-som1-ek-optee-sd ??="sama5d27_som1_ek"
OPTEE_PLATFORM_FLAVOR:sama7g5ek-optee-sd ??="sama7g54_ek"

EXTRA_OEMAKE += "PLATFORM_FLAVOR=${OPTEE_PLATFORM_FLAVOR}"

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
