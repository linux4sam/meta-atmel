do_install_append() {
        install -d ${D}${includedir}/bluez5_utils/lib
        install -d ${D}${includedir}/bluez5_utils/monitor
        install -d ${D}${includedir}/bluez5_utils/src/shared
        install -d ${D}${libdir}/bluez5_utils/lib

        install -D -m 0755 --target-directory=${D}/usr/bin/ ${B}/tools/btgatt-server

        install -m 644 ${B}/src/.libs/libshared-mainloop.a ${D}/${libdir}/bluez5_utils/lib
        install -m 644 ${B}/gdbus/.libs/libgdbus-internal.a ${D}/${libdir}/bluez5_utils/lib
        install -m 644 ${B}/lib/.libs/libbluetooth-internal.a ${D}/${libdir}/bluez5_utils/lib

        install -m 644  ${S}/lib/*.h ${D}${includedir}/bluez5_utils/lib/
        install -m 644  ${S}/src/shared/*.h ${D}${includedir}/bluez5_utils/src/shared
        install -m 644  ${S}/monitor/*.h ${D}${includedir}/bluez5_utils/monitor/
}

FILES_${PN} += "${usrbin}/btgatt*"

FILES_${PN}-staticdev += " \
    ${libdir}/bluez5_utils/lib/*.a \
    ${includedir}/bluez5_utils/lib/*.h \
    ${includedir}/bluez5_utils/src/shared/*.h \
    ${includedir}/bluez5_utils/monitor/*.h \
"
