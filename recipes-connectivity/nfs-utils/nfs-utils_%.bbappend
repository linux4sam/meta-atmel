FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG:remove = "proc-fs-mount"
RDEPENDS:${PN}-mount = ""

SYSTEMD_SERVICE:${PN}:remove = "nfs-server.service nfs-mountd.service"

do_install:append() {
    rm -f ${D}${systemd_system_unitdir}/proc-fs-nfsd.mount
    rm -f ${D}${systemd_system_unitdir}/nfs-server.service
    rm -f ${D}${systemd_system_unitdir}/nfs-mountd.service
}
