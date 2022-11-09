require at91bootstrap.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=12c44f58fe16bd407f016e45950c2f3d"

COMPATIBLE_MACHINE = '(sama5d3-xplained|sama5d3-xplained-sd|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd|sama5d27-som1-ek-optee-sd|sama5d2-icp-sd|sam9x60ek|sam9x60ek-sd|sama5d27-wlsom1-ek-sd|sama7g5ek-sd|sama7g5ek-emmc|sam9x60-curiosity|sam9x60-curiosity-sd)'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https;branch=at91bootstrap-4.x"

PV = "4.0.5+git${SRCPV}"
SRCREV = "26bc28ae4a6d42f68880cddcf9d45e5b2fd2e076"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC=${TARGET_PREFIX}gcc EXTRA_CC_ARGS="${TOOLCHAIN_OPTIONS}"'

AT91BOOTSTRAP_BIN_PATH = "${S}/build/binaries"

AT91BOOTSTRAP_CONFIG_PATH = "${S}/configs"
