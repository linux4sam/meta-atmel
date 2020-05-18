LICENSE = "CLOSED"
SRC_URI = "git://github.com/MicrochipTech/cryptoauthlib.git;branch=pkcs11;protocol=https"

PV = "1.0+git${SRCPV}"
SRCREV = "2df0eb145c7241263d07577394dd12f8b1e783f0"

S = "${WORKDIR}/git"

DEPENDS = "eudev"
RDEPENDS_${PN} = "libp11 (>= 0.4.10) gnutls-bin"
RRECOMMENDS_${PN} = "p11-kit"

inherit cmake

EXTRA_OECMAKE = ""

do_install_append_sama5d2() {
    cp -p ${D}${localstatedir}/lib/cryptoauthlib/slot.conf.tmpl ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d2-xplained board, the ATECC608A Secure4 click board must be connected to the XPRO EXT2 socket
do_install_append_sama5d2-xplained() {
    sed -i "s/interface = i2c.*/interface = i2c,0xC0,2/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}
do_install_append_sama5d2-xplained-sd() {
    sed -i "s/interface = i2c.*/interface = i2c,0xC0,2/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d27-som1-ek board, the ATECC608A is embedded in the SOM
do_install_append_sama5d27-som1-ek-sd() {
    sed -i "s/interface = i2c.*/interface = i2c,0xC0,0/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d27-wlsom1-ek board, the ATECC608A is embedded in the SOM
do_install_append_sama5d27-wlsom1-ek-sd() {
    sed -i "s/interface = i2c.*/interface = i2c,0x6A,0/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d2-icp board, the ATECC608A is embedded in the PCB
do_install_append_sama5d2-icp-sd() {
    sed -i "s/interface = i2c.*/interface = i2c,0xC0,1/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d2-ptc-ek board, the ATECC608A Secure4 click board must be connected to the XPRO EXT1 socket
do_install_append_sama5d2-ptc-ek() {
    sed -i "s/interface = i2c.*/interface = i2c,0xC0,1/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}
do_install_append_sama5d2-ptc-ek-sd() {
    sed -i "s/interface = i2c.*/interface = i2c,0xC0,1/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

FILES_${PN} = "${nonarch_libdir}/libcryptoauth.so \
	       ${sysconfdir}/cryptoauthlib/cryptoauthlib.conf \
	       ${localstatedir}/lib/cryptoauthlib/slot.conf.tmpl \
	       ${localstatedir}/lib/cryptoauthlib/0.conf \
"
FILES_${PN}-dev = ""
