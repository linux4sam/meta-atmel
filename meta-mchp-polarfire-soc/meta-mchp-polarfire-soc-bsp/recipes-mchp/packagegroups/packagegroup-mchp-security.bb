SUMMARY = "Security package group with security libraries and crypto tools"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-security \
"

RDEPENDS:packagegroup-mchp-security = "\
    cryptodev-module \
    openssl-engines \
"
