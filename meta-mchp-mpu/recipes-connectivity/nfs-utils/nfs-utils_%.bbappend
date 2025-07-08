PACKAGECONFIG:remove:mpuall = "proc-fs-mount"
RDEPENDS:${PN}-mount:mpuall = ""

SYSTEMD_SERVICE:${PN}:remove:mpuall = "nfs-server.service nfs-mountd.service"

do_install:append:mpuall () {
    rm -f ${D}${systemd_system_unitdir}/proc-fs-nfsd.mount
    rm -f ${D}${systemd_system_unitdir}/nfs-server.service
    rm -f ${D}${systemd_system_unitdir}/nfs-mountd.service
}
