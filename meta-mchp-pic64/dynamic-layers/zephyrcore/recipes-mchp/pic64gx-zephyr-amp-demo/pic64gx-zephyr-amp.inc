# Zephyr AMP Common requirements

require recipes-kernel/zephyr-kernel/zephyr-sample.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Substitute Zephyr kernel with our fork, for the moment we do that, it might
# be wise to just recreate a custom zephyr-kernel-src-x.bb at some point with
# our forks
ZEPHYR_BRANCH="main"
SRCREV_default = "d5777557c54cec9cd4b3db66e3ff413987eee393"
SRC_URI_ZEPHYR = "git://github.com/pic64gx/pic64gx-zephyr.git;protocol=https"
SRC_URI:append = " ${SRC_URI_ZEPHYR};nobranch=1;name=default;destsuffix=git/zephyr "

SRCREV_open-amp = "da78aea63159771956fe0c9263f2e6985b66e9d5"
SRC_URI_ZEPHYR_OPENAMP = "git://github.com/zephyrproject-rtos/open-amp.git;protocol=https"
SRC_URI:append = " ${SRC_URI_ZEPHYR_OPENAMP};name=open-amp;nobranch=1;destsuffix=git/modules/lib/open-amp "

SRCREV_libmetal = "243eed541b9c211a2ce8841c788e62ddce84425e"
SRC_URI_ZEPHYR_LIBMETAL = "git://github.com/zephyrproject-rtos/libmetal.git;protocol=https"
SRC_URI:append = " ${SRC_URI_ZEPHYR_LIBMETAL};name=libmetal;nobranch=1;destsuffix=git/modules/hal/libmetal "

ZEPHYR_MODULES:append = "${S}/modules/modules/lib/open-amp\;"
ZEPHYR_MODULES:append = "${S}/modules/hal/libmetal\;"
