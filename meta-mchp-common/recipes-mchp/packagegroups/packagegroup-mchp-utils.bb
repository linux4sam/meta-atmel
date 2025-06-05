SUMMARY = "Utilities package group with generic Linux tools"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-benchmark-utils \
    packagegroup-mchp-file-utils \
    packagegroup-mchp-hw-utils \
    packagegroup-mchp-system-utils \
    packagegroup-mchp-user-utils \
    packagegroup-mchp-utils \
"

RDEPENDS:packagegroup-mchp-utils = "\
    packagegroup-mchp-benchmark-utils \
    packagegroup-mchp-file-utils \
    packagegroup-mchp-hw-utils \
    packagegroup-mchp-system-utils \
    packagegroup-mchp-user-utils \
"

RDEPENDS:packagegroup-mchp-file-utils = "\
    dosfstools \
    unzip \
    zip \
"

RDEPENDS:packagegroup-mchp-system-utils = "\
    evtest \
    lrzsz \
    opkg \
    rng-tools \
    setserial \
    systemd-analyze \
"

RDEPENDS:packagegroup-mchp-hw-utils = "\
    can-utils \
    devmem2 \
    i2c-tools \
    libgpiod-tools \
    mtd-utils \
    mtd-utils-ubifs \
    phytool \
"

RDEPENDS:packagegroup-mchp-user-utils = "\
    expect \
    nano \
    screen \
"

RDEPENDS:packagegroup-mchp-benchmark-utils = "\
    lmbench \
    nbench-byte \
    stress-ng \
"
