inherit devicetree

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE:append:mpfs-video-kit = "|mpfs-video-kit"
COMPATIBLE_MACHINE:append:mpfs-icicle-kit-all = "|mpfs-icicle-kit-all"

DT_FILES_PATH:mpfs-icicle-kit-all = "${WORKDIR}/git/mpfs_icicle"
DT_FILES_PATH:mpfs-video-kit = "${WORKDIR}/git/mpfs_video"

do_compile[depends] = ""
DEPENDS:mpfs = "dtc-native"

python do_compile() {

    bb.build.exec_func('devicetree_do_compile', d)
}

do_install:mpfs() {
    cd ${B}
    for DTB_FILE in `ls *.dtbo`; do
        install -Dm 0644 ${B}/${DTB_FILE} ${D}/boot/${DTB_FILE}
    done
}

do_deploy:mpfs() {
    cd ${B}
    for DTB_FILE in `ls *.dtbo`; do
        install -Dm 0644 ${B}/${DTB_FILE} ${DEPLOYDIR}/overlays/${DTB_FILE}
    done
}

FILES:${PN} = "/boot/*"
