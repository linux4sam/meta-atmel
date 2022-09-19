do_install:append () {
    install -p ${S}/phc_ctl  ${D}/${bindir}
}
