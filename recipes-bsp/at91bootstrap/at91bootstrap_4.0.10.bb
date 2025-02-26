require at91bootstrap.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=12c44f58fe16bd407f016e45950c2f3d"

DEPENDS += " sam-ba-native"

COMPATIBLE_MACHINE = '(sama5d2-icp-sd\
|sama5d2-ptc-ek|sama5d2-ptc-ek-sd\
|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc\
|sama5d27-som1-ek|sama5d27-som1-ek-sd|sama5d27-som1-ek-optee-sd\
|sama5d27-wlsom1-ek-sd\
|sama5d29-curiosity-sd\
|sama5d3-xplained|sama5d3-xplained-sd\
|sama5d4-xplained|sama5d4-xplained-sd\
|sama7g5ek-sd|sama7g5ek-emmc|sama7g5ek-ospi|sama7g5ek-optee-sd\
|sam9x60ek|sam9x60ek-sd\
|sam9x60-curiosity|sam9x60-curiosity-sd\
|sam9x75-curiosity|sam9x75-curiosity-sd|sam9x75eb|sam9x75eb-sd\
|sama7d65-curiosity|sama7d65-curiosity-sd\
)'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https;branch=at91bootstrap-4.x"

PV = "4.0.10+git${SRCPV}"
SRCREV = "661b4d4f3361f6fc4f18dad2beb0dda7c92a5f52"

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
