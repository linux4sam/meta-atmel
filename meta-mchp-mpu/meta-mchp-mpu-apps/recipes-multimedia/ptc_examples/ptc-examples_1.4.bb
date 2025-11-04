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
RDEPENDS:${PN} = "udev-rules-mchp"
PV = "1.4+git${SRCPV}"

SRC_URI = "git://github.com/linux4sam/ptc_examples.git;protocol=https;branch=master"
SRCREV = "bb450b8a1db37d9ad4ce5d6ac849abec95f955b3"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

PACKAGECONFIG:apend:sama5d27-wlsom1-ek-sd = " sama5d27-wlsom1-ek"
PACKAGECONFIG[sama5d27-wlsom1-ek] = "-DSAMA5D27_WLSOM1_EK=ON,"

do_install:append () {
    install -D -m 0755 --target-directory=${D}${ROOT_HOME} ${S}/src/start_ptc_qt*
    install -D -m 0644 --target-directory=${D}${base_libdir}/firmware/microchip \
                       ${S}/fw/*.bin ${S}/cfg/*.bin
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES:${PN} += "${base_libdir}/firmware/microchip \
                ${ROOT_HOME}/start_ptc_qt* \
                "
COMPATIBLE_MACHINE = "(at91sam9|sama5)"
