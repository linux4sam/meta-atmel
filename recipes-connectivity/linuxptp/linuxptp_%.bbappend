do_install_append () {
    install -p ${S}/phc_ctl  ${D}/${bindir}
}
