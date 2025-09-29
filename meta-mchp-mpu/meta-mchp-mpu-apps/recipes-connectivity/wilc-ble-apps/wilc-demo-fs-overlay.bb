SUMMARY = "RootFs files needed for WILC connectivity recipies"
DESCRIPTION = "Installs scripts to demonstrate WILC WiFi apps: Start_AP.sh (AP + web server) and Start_STA.sh (STA mode)."
AUTHOR = "Microchip Technology Incorporated"
SECTION = "net"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " file://Start_AP.sh \
            file://Start_STA.sh \
            "
do_install () {
    install -D -m 0755 --target-directory=${D}${ROOT_HOME} ${WORKDIR}/Start_*
}

FILES:${PN} += "${ROOT_HOME}"

COMPATIBLE_MACHINE = "(at91sam9|sama5)"
