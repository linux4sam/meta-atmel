PACKAGES += " \
    packagegroup-mchp-egt-apps \
"

RDEPENDS:packagegroup-mchp-apps:mpuall += "\
    9bit \
    mpio \
    mxt-app \
"

RDEPENDS:packagegroup-mchp-apps:sam9x75_curiosity += "\
    ble-bluez-hci-apps \
"

RDEPENDS:packagegroup-mchp-apps:sama5d27-wlsom1-ek-sd += "\
    wilc-ble-demo \
    wilc-demo-fs-overlay \
"

RDEPENDS:packagegroup-mchp-egt-apps:mpuall += "\
    egt-benchmark \
    egt-launcher \
    egt-media \
    egt-samples \
    egt-samples-contribution \
    egt-thermostat \
    mchp-egt-demo-init \
"

RDEPENDS:packagegroup-mchp-apps:sama5d2_ptc_ek += "\
    ptc-examples \
"

RDEPENDS:packagegroup-mchp-apps:sama5d27-wlsom1-ek-sd += "\
    ptc-examples \
"
