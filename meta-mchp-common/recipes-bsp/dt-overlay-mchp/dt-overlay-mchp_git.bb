DESCRIPTION = "Compile Microchip SoCs board device tree overlays and pack them in a FIT image"
SECTION = "bsp"
LICENSE = "GPL-2.0-or-later & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=775626b7bc958bdcc525161f725ece0f \
                    file://LICENSES/GPL-2.0;md5=e6a75371ba4d16749254a51215d13f97 \
                    file://LICENSES/MIT;md5=e8f57dd048e186199433be2c41bd3d6d"

inherit deploy

S = "${WORKDIR}/git"
PACKAGE_ARCH = "${MACHINE_ARCH}"
DEPENDS = "virtual/kernel u-boot-mkimage-native dtc-native"

SRC_URI = "git://github.com/linux4microchip/dt-overlay-mchp.git;protocol=https;branch=master"
SRCREV  = "879d063e8a45081892490aaa46a7453de31d2475"
PV      = "1.0+git${SRCPV}"

do_compile[depends] += "virtual/kernel:do_deploy virtual/kernel:do_shared_workdir"

do_compile () {
    # Check to properly identify the board
    if [ -z "${DT_MACHINE}" ]; then
        bbnote "No DT_MACHINE set for ${DT_MACHINE}"
        exit 1
    fi

    if [ -d "${DT_MACHINE}" ]; then
        bbnote "Compiling DTBOs"
        oe_runmake DTC=dtc KERNEL_DIR=${STAGING_KERNEL_DIR} KERNEL_BUILD_DIR=${KERNEL_PATH} ${DT_MACHINE}_dtbos
    else
        bbfatal "No DTBOs to compile"
    fi

    # Over-ride itb target in Makefile
    if [ -e "${DT_MACHINE}.its" ]; then
        bbnote "Creating the FIT image"
        DTC_OPTIONS="-Wno-unit_address_vs_reg -Wno-graph_child_address -Wno-pwms_property"
        mkimage -D "-i${DEPLOY_DIR_IMAGE} -p 1000 ${DTC_OPTIONS}" -f ${DT_MACHINE}.its ${DT_MACHINE}.itb
    else
        bbfatal "No its file to create FIT images"
    fi
}

addtask install after do_compile

do_install () {
    # Copy files to /boot
    if [ -e ${DT_MACHINE} ]; then
        install -d ${D}/boot
        install ${DT_MACHINE}/${DT_MACHINE}*.dtbo ${D}/boot
    fi;

    if [ -e ${DT_MACHINE}.itb ]; then
        install -d ${D}/boot
        install ${DT_MACHINE}.itb ${D}/boot/
        install ${DT_MACHINE}.its ${D}/boot/
    fi;
}

addtask deploy after do_install

do_deploy () {
    #bbnote "Copying ${fit_image_basename}.itb and source file to ${DEPLOYDIR}..."
    if [ -e ${DT_MACHINE}.itb ]; then
        install ${DT_MACHINE}.itb ${DEPLOYDIR}/
        install ${DT_MACHINE}.its ${DEPLOYDIR}/
    fi;
}

FILES:${PN} = "/boot/*"
