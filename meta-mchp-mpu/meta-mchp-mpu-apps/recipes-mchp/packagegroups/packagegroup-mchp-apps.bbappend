PACKAGES += " \
    packagegroup-mchp-apps-egt \
"

RDEPENDS:packagegroup-mchp-apps += "\
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

RDEPENDS:packagegroup-mchp-apps:sama5d27-wlsom1-ek-sd += "\
    wilc-ble-demo \
    wilc-demo-fs-overlay \
"

RDEPENDS:packagegroup-mchp-apps-egt = "\
    egt-benchmark \
    egt-launcher \
    egt-media \
    egt-samples \
    egt-samples-contribution \
    egt-thermostat \
    mchp-egt-demo-init \
"

RDEPENDS:packagegroup-mchp-apps:sama5d2_ptc_ek = "\
    ptc-examples \
"
