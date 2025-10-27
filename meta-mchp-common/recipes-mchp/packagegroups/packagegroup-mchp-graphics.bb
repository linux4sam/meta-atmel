SUMMARY = "Package group for graphics software and libraries."

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-graphics \
"

RDEPENDS:packagegroup-mchp-graphics = "\
    libdrm \
    libdrm-tests \
    liberation-fonts \
"
