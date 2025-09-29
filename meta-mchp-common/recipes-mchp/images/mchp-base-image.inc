inherit core-image

IMAGE_FEATURES += "ssh-server-openssh package-management debug-tweaks"

IMAGE_INSTALL:append = " \
    kernel-modules \
    packagegroup-base \
    packagegroup-core-full-cmdline \
    packagegroup-mchp-apps \
    packagegroup-mchp-dev \
    packagegroup-mchp-networking \
    packagegroup-mchp-security \
    packagegroup-mchp-utils \
"
