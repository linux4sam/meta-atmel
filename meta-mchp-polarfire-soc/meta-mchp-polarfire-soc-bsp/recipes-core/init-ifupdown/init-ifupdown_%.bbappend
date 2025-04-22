FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://interfaces"

FILES:${PN} += " ${sysconfdir}/repart.d/* \
                "

do_install:append(){
    install -m 0644 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
}
