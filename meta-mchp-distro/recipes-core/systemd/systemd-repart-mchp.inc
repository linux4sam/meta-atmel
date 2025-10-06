FILESEXTRAPATHS:prepend:autoresize := "${THISDIR}/files:"

PACKAGECONFIG:append:autoresize := "openssl repart"

SRC_URI:append:autoresize = " file://50-root.conf"

do_install:append:autoresize (){
    install -d ${D}${sysconfdir}/repart.d/
    install -m 0644 ${WORKDIR}/50-root.conf ${D}${sysconfdir}/repart.d/
}

FILES:${PN} += " ${sysconfdir}/repart.d/*"
