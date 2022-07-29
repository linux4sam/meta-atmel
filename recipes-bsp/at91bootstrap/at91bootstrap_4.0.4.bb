require at91bootstrap.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=12c44f58fe16bd407f016e45950c2f3d"

COMPATIBLE_MACHINE = '(sam9x60-curiosity|sam9x60-curiosity-sd)'

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=https"

PV = "4.0.4+git${SRCPV}"
SRCREV = "a06446822f2998691ad168a98905a3946ea5fab6"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC=${TARGET_PREFIX}gcc EXTRA_CC_ARGS="${TOOLCHAIN_OPTIONS}"'

AT91BOOTSTRAP_BIN_PATH = "${S}/build/binaries"

AT91BOOTSTRAP_CONFIG_PATH = "${S}/configs"
