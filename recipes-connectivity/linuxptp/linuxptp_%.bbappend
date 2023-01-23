do_install:append () {
    install -p ${S}/phc_ctl  ${D}/${sbindir}
    install -p ${S}/ptp4l    ${D}/${sbindir}
}
