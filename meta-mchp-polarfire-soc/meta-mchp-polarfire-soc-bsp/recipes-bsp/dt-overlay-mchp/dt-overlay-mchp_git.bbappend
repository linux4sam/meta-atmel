inherit devicetree

COMPATIBLE_MACHINE = "(mpfs-icicle-kit-all|mpfs-video-kit)"

S = "${WORKDIR}/git"

DT_FILES_PATH:mpfs-icicle-kit-all = "${WORKDIR}/git/mpfs_icicle"
DT_FILES_PATH:mpfs-video-kit = "${WORKDIR}/git/mpfs_video"

do_compile[depends] = ""
DEPENDS = "dtc-native"

python do_compile() {

    bb.build.exec_func('devicetree_do_compile', d)
}

do_install() {
    cd ${B}
    for DTB_FILE in `ls *.dtbo`; do
        install -Dm 0644 ${B}/${DTB_FILE} ${D}/boot/${DTB_FILE}
    done
}

do_deploy() {
    cd ${B}
    for DTB_FILE in `ls *.dtbo`; do
        install -Dm 0644 ${B}/${DTB_FILE} ${DEPLOYDIR}/overlays/${DTB_FILE}
    done
}

FILES:${PN} = "/boot/*"
