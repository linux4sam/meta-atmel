SUMMARY = "PTC examples"
DESCRIPTION = "The PTC examples are composed of binary configurations and demo applications."
AUTHOR = "Microchip Technology Incorporated"
HOMEPAGE = "https://github.com/linux4sam/ptc_examples"
SECTION = "examples"
LICENSE = "Apache-2.0 & MICROCHIP_FW & PTC_config"
LIC_FILES_CHKSUM = "file://src/COPYING;md5=e23fadd6ceef8c618fc1c65191d846fa \
                    file://cfg/LICENCE.ptc_cfg;beginline=6;md5=cba5f8f7c9871fdbc6daf1a384e8fb4c \
                    file://fw/LICENCE.ptc_fw;beginline=6;md5=6c2a5175a10e876229208f0a4924daf1 \
                    "
NO_GENERIC_LICENSE[PTC_config] = "cfg/LICENCE.ptc_cfg"
DEPENDS = "libevdev libgpiod"
RDEPENDS_${PN} = "udev-rules-at91"
PV = "1.3+git${SRCPV}"

SRC_URI = "git://github.com/linux4sam/ptc_examples.git;protocol=git"
SRCREV = "625f1066a1da81c146947855f4b4686bb0079b50"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} \
                CFLAGS="${TARGET_CC_ARCH} ${TOOLCHAIN_OPTIONS} ${CFLAGS}" \
                LDFLAGS="${TARGET_CC_ARCH} ${TOOLCHAIN_OPTIONS} ${LDFLAGS}" \
                '

EXTRA_OEMAKE_append_sama5d27-wlsom1-ek-sd += 'CFLAGS+="-DSAMA5D27_WLSOM1_EK"'

do_compile () {
    oe_runmake
}

do_install () {
    install -D -m 0755 --target-directory=${D}/usr/bin ${S}/src/ptc_qt*_demo
    install -D -m 0755 --target-directory=${D}/home/root ${S}/src/start_ptc_qt*
    install -D -m 0644 --target-directory=${D}/lib/firmware/microchip \
                       ${S}/fw/*.bin ${S}/cfg/*.bin
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} += "${base_libdir}/firmware/microchip \
                /home/root/start_ptc_qt* \
                "
COMPATIBLE_MACHINE = "(at91sam9|sama5)"
