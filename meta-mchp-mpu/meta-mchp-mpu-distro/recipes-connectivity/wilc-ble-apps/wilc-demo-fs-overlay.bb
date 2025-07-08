SUMMARY = "RootFs files needed for WILC connectivity recipies"
DESCRIPTION = "The recipe installs following 3 different types of files to  \
	the rootfs							    \
	1) Scripts to demonstrate WiFi/BLE applications on WILC		    \
		a. Start_AP.sh	-> Starts WILC as AP and Hosts Web server   \
		b. Start_STA.sh	-> Connects to a AP in STA mode	 	    \
		c. Start_BT.sh	-> Start BLE Applications		    \
				(Heartrate/Transparent/wifiProv service)    \
		d. Start_Provision.sh -> Places WILC back to Provision Mode \
									    \
	2) HTML files which enables web based provisioning to provide WiFi  \
	credentials. These HTML files are used by the NGINX webserver.	    \
									    \
	3) Hostapd configuration files needed to bring up the WILC in AP    \
	mode, the configuration file contains SSID and Beaconing information"

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
