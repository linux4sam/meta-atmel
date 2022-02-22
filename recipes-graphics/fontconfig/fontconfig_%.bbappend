FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
    file://local.conf\
    "

do_install:append() {
	install -Dm 644 --target-directory=${D}${sysconfdir}/fonts ${WORKDIR}/local.conf
}

FILES:${PN} += "${sysconfdir}/fonts"
