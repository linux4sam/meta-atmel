PACKAGES += " \
    packagegroup-mchp-apps-amp \
"

RDEPENDS:packagegroup-mchp-apps:mpfs-icicle-kit = "\
    polarfire-soc-linux-examples-can \
    polarfire-soc-linux-examples-dma \
    polarfire-soc-linux-examples-dt-overlays \
    polarfire-soc-linux-examples-gateware \
    polarfire-soc-linux-examples-lsram \
    polarfire-soc-linux-examples-pdma \
    polarfire-soc-linux-examples-system-services \
"

RDEPENDS:packagegroup-mchp-apps-amp:mpfs-icicle-kit-amp = "\
    kernel-module-rpmsg-char \
    kernel-module-rpmsg-client-sample \
    kernel-module-rpmsg-ctrl \
    kernel-module-rpmsg-tty \
    polarfire-soc-amp-examples \
    polarfire-soc-linux-examples-amp \
    polarfire-soc-linux-examples-can \
    polarfire-soc-linux-examples-dma \
    polarfire-soc-linux-examples-dt-overlays \
    polarfire-soc-linux-examples-lsram \
    polarfire-soc-linux-examples-pdma \
    polarfire-soc-linux-examples-system-services \
"

RDEPENDS:packagegroup-mchp-apps:mpfs-video-kit = "\
    polarfire-soc-linux-examples-dt-overlays \
"

RDEPENDS:packagegroup-mchp-apps:mpfs-disco-kit = "\
    polarfire-soc-linux-examples-dma \
    polarfire-soc-linux-examples-dt-overlays \
    polarfire-soc-linux-examples-lsram \
    polarfire-soc-linux-examples-pdma \
    polarfire-soc-linux-examples-system-services \
"
