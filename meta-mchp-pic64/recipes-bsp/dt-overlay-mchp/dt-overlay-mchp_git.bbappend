inherit devicetree

COMPATIBLE_MACHINE:append:pic64gx-curiosity-kit = "|pic64gx-curiosity-kit"
COMPATIBLE_MACHINE:append:pic64gx-curiosity-kit-amp = "|pic64gx-curiosity-kit-amp"

S = "${WORKDIR}/git"

DT_FILES_PATH:pic64gx = "${WORKDIR}/git/pic64gx_curiosity_kit"

do_compile[depends] = ""
DEPENDS:pic64gx = "dtc-native"

python do_compile() {

    bb.build.exec_func('devicetree_do_compile', d)
}

do_install:pic64gx() {
    cd ${B}
    for DTB_FILE in `ls *.dtbo`; do
        install -Dm 0644 ${B}/${DTB_FILE} ${D}/boot/${DTB_FILE}
    done
}

do_deploy:pic64gx() {
    cd ${B}
    for DTB_FILE in `ls *.dtbo`; do
        install -Dm 0644 ${B}/${DTB_FILE} ${DEPLOYDIR}/overlays/${DTB_FILE}
    done
}

FILES:${PN} += "/boot/*"
