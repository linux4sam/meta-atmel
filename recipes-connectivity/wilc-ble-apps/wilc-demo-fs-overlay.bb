SUMMARY = "RootFs files needed for WILC connectivity recipies"
DESCRIPTION = "The recipie installs following 3 different types of files    \
	to the rootfs							    \
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
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/MicrochipTech/linux4sam-wilc-demo-fs-overlay.git;protocol=git"
SRCREV = "bb35c3a12b23255f15fde44ab04a1635d69bc6df"
S = "${WORKDIR}/git"

do_install () {
    install -D -m 0755 --target-directory=${D}${ROOT_HOME} ${S}/sama5d27_wlsom1_ek/root/Start_*
    install -d ${D}${datadir}/nginx/html
    install -D -m 0644 --target-directory=${D}${datadir}/nginx/html/ ${S}/sama5d27_wlsom1_ek/usr/html/*
    install -D -m 0644 --target-directory=${D}${sysconfdir}/ ${S}/sama5d27_wlsom1_ek/etc/wilc*
}

FILES_${PN} += "/home/root/*"
FILES_${PN} += "${datadir}/nginx/html/*"
FILES_${PN} += "${sysconfdir}/wilc*"

inherit allarch
do_compile[noexec] = "1"
INHIBIT_DEFAULT_DEPS="1"

COMPATIBLE_MACHINE = "(at91sam9|sama5)"
