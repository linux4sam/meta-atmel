SUMMARY = "Utilities package group with generic Linux tools"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-utils \
    packagegroup-mchp-benchmark-utils \
    packagegroup-mchp-file-utils \
    packagegroup-mchp-hw-utils \
    packagegroup-mchp-system-utils \
    packagegroup-mchp-user-utils \
"

RDEPENDS:packagegroup-mchp-utils = "\
    packagegroup-mchp-benchmark-utils \
    packagegroup-mchp-file-utils \
    packagegroup-mchp-hw-utils \
    packagegroup-mchp-system-utils \
    packagegroup-mchp-user-utils \
"

RDEPENDS:packagegroup-mchp-benchmark-utils = "\
    stress-ng \
"

RDEPENDS:packagegroup-mchp-file-utils = "\
    dosfstools \
    unzip \
    zip \
"

RDEPENDS:packagegroup-mchp-system-utils = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-analyze', '', d)} \
    lrzsz \
    opkg \
    rng-tools \
    setserial \
"

RDEPENDS:packagegroup-mchp-hw-utils = "\
    i2c-tools \
    mtd-utils \
    mtd-utils-ubifs \
"

RDEPENDS:packagegroup-mchp-user-utils = "\
    expect \
    screen \
"
