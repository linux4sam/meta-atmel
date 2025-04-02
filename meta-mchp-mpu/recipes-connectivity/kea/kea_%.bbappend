FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

SRC_URI += " file://0001-keactrl.in-create-var-lib-kea-and-var-run-kea-folder.patch \
             file://kea-dhcp4.conf \
"

do_install:append () {
    install -d ${D}${sysconfdir}/kea
    install -m 0644 ${WORKDIR}/kea-dhcp4.conf ${D}${sysconfdir}/kea/kea-dhcp4.conf
}
