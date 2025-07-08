SUMMARY = "Wireless Kit Webpages"
AUTHOR = "Microchip Technology Inc"
DESCRIPTION = "Fetches and installs the wireless kit webpages from GitHub \
	for the Out of the box experience(OOBE) for our wireless kits."
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

DEPENDS = "nginx"
RDEPENDS:${PN} = "nginx"

SRC_URI = "git://github.com/MicrochipTech/wireless_kit_webpages.git;protocol=https;branch=main"
PV = "1.0+git${SRCPV}"
SRCREV ="614bf48d8c8b87089748e4997f332cf2d5d73551"

S = "${WORKDIR}/git"

do_install() {

    # Create a new subdirectory under /var/www/localhost/html
    install -d ${D}/var/www/localhost/html/wireless_kit

    # Install new content from the fetched repository
    install -D -m 0755 ${S}/* --target-directory=${D}/var/www/localhost/html/wireless_kit

}

FILES:${PN} += "/var/www/localhost/html/wireless_kit"
