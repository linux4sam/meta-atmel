DESCRIPTION = "Microchip CryptoAuthentication Library"

LICENSE = "MICROCHIP_CAL"
LIC_FILES_CHKSUM = "file://license.txt;endline=18;md5=a6d0adc44da1eb4799100655116c5ca4"

SRC_URI = "git://github.com/MicrochipTech/cryptoauthlib.git;branch=main;protocol=https \
           file://cryptoauthlib.module \
           file://0001-pkcs11-Fix-deadlock-in-pkcs11_token_init.patch \
           file://0002-pkcs11-Fix-user-s-PIN-usage.patch \
           "

PV = "1.0+git${SRCPV}"
SRCREV = "e981e09edbb902ee49d74365e66b7292ebad8934"

S = "${WORKDIR}/git"

DEPENDS = "udev openssl"
RDEPENDS_${PN} = "libp11 (>= 0.4.10) gnutls-bin"
RRECOMMENDS_${PN} = "p11-kit"

inherit cmake

EXTRA_OECMAKE = " \
    -DATCA_HAL_I2C=ON \
    -DATCA_PKCS11=ON \
    -DATCA_OPENSSL=ON \
    -DATCA_ATECC508A_SUPPORT=ON \
    -DATCA_ATECC608_SUPPORT=ON \
    -DATCA_BUILD_SHARED_LIBS=ON \
    -DATCA_TNGTLS_SUPPORT=ON \
    -DATCA_TNGLORA_SUPPORT=ON \
    -DATCA_TFLEX_SUPPORT=ON \
    -DATCA_USE_ATCAB_FUNCTIONS=ON \
"

CFLAGS += "-fcommon"

do_install_append_sama5d2() {
    install -Dm 644 ${WORKDIR}/cryptoauthlib.module ${D}${datadir}/p11-kit/modules/cryptoauthlib.module
    cp -p ${D}${localstatedir}/lib/cryptoauthlib/slot.conf.tmpl ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d2-xplained board, the ATECC608A Secure4 click board must be connected to the XPRO EXT2 socket
do_install_append_sama5d2-xplained() {
    sed -i "s/interface = .*/interface = i2c,0xC0,2/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}
do_install_append_sama5d2-xplained-sd() {
    sed -i "s/interface = .*/interface = i2c,0xC0,2/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d27-som1-ek board, the ATECC608A is embedded in the SOM
do_install_append_sama5d27-som1-ek-sd() {
    sed -i "s/interface = .*/interface = i2c,0xC0,0/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d27-wlsom1-ek board, the ATECC608A is embedded in the SOM
do_install_append_sama5d27-wlsom1-ek-sd() {
    sed -i "s/interface = .*/interface = i2c,0x6A,0/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d2-icp board, the ATECC608A is embedded in the PCB
do_install_append_sama5d2-icp-sd() {
    sed -i "s/interface = .*/interface = i2c,0xC0,1/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

# On sama5d2-ptc-ek board, the ATECC608A Secure4 click board must be connected to the XPRO EXT1 socket
do_install_append_sama5d2-ptc-ek() {
    sed -i "s/interface = .*/interface = i2c,0xC0,1/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}
do_install_append_sama5d2-ptc-ek-sd() {
    sed -i "s/interface = .*/interface = i2c,0xC0,1/"  ${D}${localstatedir}/lib/cryptoauthlib/0.conf
}

FILES_${PN} = "${nonarch_libdir}/libcryptoauth.so \
	       ${sysconfdir}/cryptoauthlib/cryptoauthlib.conf \
	       ${localstatedir}/lib/cryptoauthlib/slot.conf.tmpl \
	       ${datadir}/p11-kit/modules/cryptoauthlib.module \
	       ${localstatedir}/lib/cryptoauthlib/0.conf \
"
FILES_${PN}-dev = " \
		${includedir}/cryptoauthlib/* \
"
