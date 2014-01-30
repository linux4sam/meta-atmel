# linux-yocto-custom.bb:
#
#   An example kernel recipe that uses the linux-yocto and oe-core
#   kernel classes to apply a subset of yocto kernel management to git
#   managed kernel repositories.
#
#   To use linux-yocto-custom in your layer, create a
#   linux-yocto-custom.bbappend file containing at least the following
#   lines:
#
#     FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
#     COMPATIBLE_MACHINE_yourmachine = "yourmachine"
#
#   You must also provide a Linux kernel configuration. The most direct
#   method is to copy your .config to files/defconfig in your layer,
#   in the same directory as the bbappend and add file://defconfig to
#   your SRC_URI.
#
#   To use the yocto kernel tooling to generate a BSP configuration
#   using modular configuration fragments, see the yocto-bsp and
#   yocto-kernel tools documentation.
#
# Warning:
#
#   Building this example without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition (for kernel v3.4 only):
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition (for kernel v3.4 only):
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc
LINUX_VERSION ?= "3.10"
LINUX_VERSION_EXTENSION ?= "-custom"
KBRANCH ?= "3.10-at91"

# Override SRC_URI in a bbappend file to point at a different source
# tree if you do not want to build from Linus' tree.
SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH};nocheckout=1"
SRC_URI += "file://defconfig"

SRCREV="7af80e5ee631aa0ee817aa2a093d5ece8eda2975"
PV = "${LINUX_VERSION}+${SRCREV}"

PR = "r1"

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "(sama5d3xek|sama5d3_xplained|at91sam9x5ek)"

