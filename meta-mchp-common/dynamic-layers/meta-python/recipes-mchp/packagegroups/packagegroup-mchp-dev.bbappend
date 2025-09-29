PACKAGES += " \
    packagegroup-mchp-dev-nodejs \
"

RDEPENDS:packagegroup-mchp-dev-python += "\
    python3-pyserial \
    python3-smbus \
"

RDEPENDS:packagegroup-mchp-dev-nodejs += "${@('' if any(t in d.getVar('TUNE_FEATURES') for t in ['armv4','armv5','arm926','mips64']) else 'nodejs nodejs-npm')}"
