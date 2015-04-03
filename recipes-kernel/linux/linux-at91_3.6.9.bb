# See poky/meta-skeleton/recipes-kernel/linux/linux-yocto-custom.bb for
# documentation

LINUX_VERSION ?= "3.6.9"
LINUX_VERSION_EXTENSION ?= "-at91"
KBRANCH ?= "linux-3.6.9-at91"

KCONFIG_MODE="--alldefconfig"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc


# Override SRC_URI in a bbappend file to point at a different source
# tree if you do not want to build from Linus' tree.
SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH};nocheckout=1"
SRC_URI += "file://defconfig"
SRC_URI_append_at91sam9x5ek += "file://at91sam9x5ek/UBI_config.cfg"


# Override SRCREV to point to a different commit in a bbappend file to
# build a different release of the Linux kernel.
# tag: v3.4 76e10d158efb6d4516018846f60c2ab5501900bc
SRCREV="linux-3.6.9-at91"
PV = "${LINUX_VERSION}+${SRCPV}"


PR = "r1"

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "(sama5d3xek|at91sam9x5ek)"
