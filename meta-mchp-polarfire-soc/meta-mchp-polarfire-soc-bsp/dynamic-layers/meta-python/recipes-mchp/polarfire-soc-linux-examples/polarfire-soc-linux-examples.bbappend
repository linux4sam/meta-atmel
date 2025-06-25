inherit systemd

RDEPENDS:${PN}-iiohttpserver += "collectd python3-flask"

PACKAGES += " \
    ${PN}-iiohttpserver \
"

INSANE_SKIP:${PN}-iiohttpserver += "file-rdeps ldflags debug-files"

EXAMPLE_FILES += "\
    ethernet \
"

do_install() {
    install -d ${D}/opt/microchip
    chmod a+x ${D}/opt/microchip

    for i in ${EXAMPLE_FILES}; do
        install -d ${D}/opt/microchip/$(dirname $i)/$(basename $i)
        cp -rfd ${S}/$i ${D}/opt/microchip/$(dirname $i)

        if [ "${i}" = "ethernet" ]; then
            # Symbolic Link for iiohttpserver
            ln -s -r ${D}/opt/microchip/ethernet/iio-http-server ${D}/opt/microchip/iiohttpserver

            # Install the iio-http-server
            install -d ${D}${systemd_unitdir}/system
            install -m 0644 ${S}/ethernet/iio-http-server/collection/collectdiio.service ${D}${systemd_unitdir}/system
        fi
    done
}

FILES:${PN}-iiohttpserver = " \
    /opt/microchip/ \
"

SYSTEMD_PACKAGES = "${PN}-iiohttpserver"
SYSTEMD_SERVICE:${PN}-iiohttpserver = "collectdiio.service"
SYSTEMD_AUTO_ENABLE:${PN}-iiohttpserver = "disable"
