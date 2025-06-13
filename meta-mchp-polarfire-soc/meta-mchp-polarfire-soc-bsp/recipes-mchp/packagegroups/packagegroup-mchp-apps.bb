SUMMARY = "PolarFire SoC Applications and Demos"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    packagegroup-mchp-apps \
    packagegroup-mchp-apps-amp \
"

RDEPENDS:packagegroup-mchp-apps = "\
    polarfire-soc-linux-examples \
"

RDEPENDS:packagegroup-mchp-apps-amp:mpfs-icicle-kit-es-amp = "\
    polarfire-soc-amp-examples \
    kernel-module-rpmsg-char \
    kernel-module-rpmsg-client-sample \
    kernel-module-rpmsg-ctrl \
    kernel-module-rpmsg-tty \
"
