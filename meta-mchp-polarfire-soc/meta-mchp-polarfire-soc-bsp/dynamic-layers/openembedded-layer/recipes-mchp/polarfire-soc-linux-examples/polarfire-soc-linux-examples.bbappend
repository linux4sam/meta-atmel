DEPENDS += "libgpiod"
RDEPENDS:${PN}-gpio += "libgpiod"

PACKAGES += " \
    ${PN}-gpio \
"

INSANE_SKIP:${PN}-gpio += "file-rdeps ldflags debug-files"

EXAMPLE_FILES += "\
    gpio \
"

FILES:${PN}-gpio = "/opt/microchip/gpio/"
