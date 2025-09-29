PACKAGES += " \
    packagegroup-mchp-dev-nodejs \
"

RDEPENDS:packagegroup-mchp-dev-python += "\
    python3-pyserial \
    python3-smbus \
"

RDEPENDS:packagegroup-mchp-dev-nodejs += "\
    nodejs \
    nodejs-npm \
"
