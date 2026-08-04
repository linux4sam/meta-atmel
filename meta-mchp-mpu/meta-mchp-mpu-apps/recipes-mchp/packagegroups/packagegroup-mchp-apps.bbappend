PACKAGES:append = " \
    packagegroup-mchp-egt-apps \
"

RDEPENDS:packagegroup-mchp-apps:append:mpuall = "\
    9bit \
    mpio \
    mxt-app \
    wilc-demo-fs-overlay \
"

RDEPENDS:packagegroup-mchp-apps:append:sam9x75_curiosity = "\
    ble-bluez-hci-apps \
"

RDEPENDS:packagegroup-mchp-apps:append:sama5d27-wlsom1-ek-sd = "\
    ptc-examples \
    wilc-ble-demo \
"

RDEPENDS:packagegroup-mchp-egt-apps:append:mpuall = "\
    egt-benchmark \
    egt-launcher \
    egt-media \
    egt-samples \
    egt-samples-contribution \
    egt-thermostat \
    mchp-egt-demo-init \
    sama7d65-power-consumption-app-note \
"

RDEPENDS:packagegroup-mchp-apps:append:sama5d2_ptc_ek = "\
    ptc-examples \
"
