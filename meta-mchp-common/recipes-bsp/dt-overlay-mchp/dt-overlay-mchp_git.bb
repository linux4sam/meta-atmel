DESCRIPTION = "Compile Microchip SoCs board device tree overlays and pack them in a FIT image"
SECTION = "bsp"
LICENSE = "GPL-2.0-or-later & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=775626b7bc958bdcc525161f725ece0f \
                    file://LICENSES/GPL-2.0;md5=e6a75371ba4d16749254a51215d13f97 \
                    file://LICENSES/MIT;md5=e8f57dd048e186199433be2c41bd3d6d"

inherit devicetree

SRC_URI = "git://github.com/linux4microchip/dt-overlay-mchp.git;protocol=https;branch=master"
SRCREV  = "4c6f612138de2fc477e7aa1fd1ab527ab94cc461"
PV      = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

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
