PACKAGES += " \
    packagegroup-mchp-apps-amp \
"

RDEPENDS:packagegroup-mchp-apps:pic64gx-curiosity-kit = "\
    pic64gx-linux-examples-dt-overlays \
"

RDEPENDS:packagegroup-mchp-apps-amp:pic64gx-curiosity-kit-amp = "\
    pic64gx-linux-examples-amp \
    pic64gx-linux-examples-dt-overlays \
"
