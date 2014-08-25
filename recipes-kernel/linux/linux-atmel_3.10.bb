# Copyright (C) 2012, 2014 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel
require recipes-kernel/linux/linux-dtb.inc

KBRANCH_DEFAULT = "standard/base"
KBRANCH = "${KBRANCH_DEFAULT}"

SRCBRANCH_sama5d4ek = "linux-3.10-at91"
SRC_URI_sama5d4ek = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${SRCBRANCH}"
SRC_URI_sama5d4ek += "file://defconfig"
SRCREV_sama5d4ek = "d67968b5ec5725ed91ae31176456dc4b6ebd58e6"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(sama5d4ek)"
