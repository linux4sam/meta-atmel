SUMMARY = "Package group for general development tools and libraries."

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-dev \
    packagegroup-mchp-dev-python \
    packagegroup-mchp-dev-tools \
"

RDEPENDS:packagegroup-mchp-dev = "\
    packagegroup-mchp-dev-python \
    packagegroup-mchp-dev-tools \
"

RDEPENDS:packagegroup-mchp-dev-tools = "\
    dtc \
    dtc-misc \
    elfutils \
    gdb \
    git \
    strace \
"

RDEPENDS:packagegroup-mchp-dev-python = "\
    python3-ctypes \
    python3-pip \
"
