require at91bootstrap.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=12c44f58fe16bd407f016e45950c2f3d"

inherit mchp-compat-machines

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https;branch=at91bootstrap-4.x"

PV = "4.0.12+git${SRCPV}"
SRCREV = "a3edcba5e0ebf5a269093e3691b069f3d3354768"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC=${TARGET_PREFIX}gcc EXTRA_CC_ARGS="${TOOLCHAIN_OPTIONS}"'

AT91BOOTSTRAP_BIN_PATH = "${S}/build/binaries"

AT91BOOTSTRAP_CONFIG_PATH = "${S}/configs"

do_deploy:append:sama7d65 () {
    install ${AT91BOOTSTRAP_BIN_PATH}/boot-plaintextimg.bin ${DEPLOYDIR}/${AT91BOOTSTRAP_IMAGE}

    cd ${DEPLOYDIR}
    ln -sf ${AT91BOOTSTRAP_IMAGE} ${AT91BOOTSTRAP_SYMLINK}
    ln -sf ${AT91BOOTSTRAP_IMAGE} boot-plaintextimg.bin

    # Create a symlink ready for file copy on SD card
    rm -f boot.bin BOOT.BIN
    ln -sf ${AT91BOOTSTRAP_IMAGE} BOOT.BIN
}
