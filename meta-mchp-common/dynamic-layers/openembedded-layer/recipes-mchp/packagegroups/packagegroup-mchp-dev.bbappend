PACKAGES += " \
    packagegroup-mchp-dev-nodejs \
"

RDEPENDS:packagegroup-mchp-dev-nodejs += "${@('' if any(t in d.getVar('TUNE_FEATURES') for t in ['armv4','armv5','arm926','mips64', 'riscv64']) else 'nodejs nodejs-npm')}"
