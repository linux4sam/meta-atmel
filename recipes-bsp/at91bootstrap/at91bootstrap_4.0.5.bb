require at91bootstrap.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=12c44f58fe16bd407f016e45950c2f3d"

COMPATIBLE_MACHINE = '(sama5d3-xplained|sama5d3-xplained-sd|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd|sama5d27-som1-ek-optee-sd|sama5d2-icp-sd|sam9x60ek|sam9x60ek-sd|sama5d27-wlsom1-ek-sd|sama7g5ek-sd|sama7g5ek-emmc|sama7g5ek-ospi|sam9x60-curiosity|sam9x60-curiosity-sd|sam9x75eb|sam9x75eb-sd)'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https;branch=sam9x7_early"

PV = "4.0.5+git${SRCPV}"
SRCREV = "dd4cd20187c27b2ac5640742cdc7381e22153e23"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC=${TARGET_PREFIX}gcc EXTRA_CC_ARGS="${TOOLCHAIN_OPTIONS}"'

AT91BOOTSTRAP_BIN_PATH = "${S}/build/binaries"

AT91BOOTSTRAP_CONFIG_PATH = "${S}/configs"
