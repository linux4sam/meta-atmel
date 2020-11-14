FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://local.conf\
    "

do_install_append() {
	install -Dm 644 --target-directory=${D}${sysconfdir}/fonts ${WORKDIR}/local.conf
}

FILES_${PN} += "${sysconfdir}/fonts"
