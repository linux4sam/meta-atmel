DESCRIPTION = "Microchip CryptoAuthentication Library"

LICENSE = "MICROCHIP_CAL"
LIC_FILES_CHKSUM = "file://license.txt;endline=18;md5=7a38fc60c2fcad312a03b337dea8a96d"

SRC_URI = "git://github.com/MicrochipTech/cryptoauthlib.git;branch=main;protocol=https \
           file://cryptoauthlib.module \
	   file://0001-pkcs11-add-KeyLen-condition.patch \
           "

PV = "1.0+git${SRCPV}"
SRCREV = "caf67be64865a126c0cb23ac610213083baa6a60"

S = "${WORKDIR}/git"

DEPENDS = "udev openssl"
RDEPENDS:${PN} = "libp11 (>= 0.4.10) gnutls-bin"
RRECOMMENDS:${PN} = "p11-kit"

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

i2c_addr() {
    case $1 in
        sama5d2-icp-sd) machine_i2c_addr="0xC0,1" ;;
        sama5d2-ptc-ek) machine_i2c_addr="0xC0,1" ;;
        sama5d2-ptc-ek-sd) machine_i2c_addr="0xC0,1" ;;
        sama5d2-xplained) machine_i2c_addr="0xC0,2" ;;
        sama5d2-xplained-sd) machine_i2c_addr="0xC0,2" ;;
        sama5d27-som1-ek-sd) machine_i2c_addr="0xC0,0" ;;
        sama5d27-wlsom1-ek-sd) machine_i2c_addr="0x6A,0" ;;
        sama5d29-curiosity-sd) machine_i2c_addr="0x6A,1" ;;
        sama7g5ek-sd) machine_i2c_addr="0xC0,1" ;;
        sama7g5ek-emmc) machine_i2c_addr="0xC0,1" ;;
        sam9x60ek-sd) machine_i2c_addr="0x6A,1" ;;
        sam9x60-curiosity-sd) machine_i2c_addr="0x6A,0" ;;
        sam9x75-curiosity-sd) machine_i2c_addr="0x6A,1" ;;
        *) machine_i2c_addr="" ;;
    esac
}

do_install:append() {

    i2c_addr ${MACHINE}

    # Install module and conf for all machines
    install -Dm 644 ${WORKDIR}/cryptoauthlib.module ${D}${datadir}/p11-kit/modules/cryptoauthlib.module
    cp -p ${D}${localstatedir}/lib/cryptoauthlib/slot.conf.tmpl ${D}${localstatedir}/lib/cryptoauthlib/0.conf


    # Update interface using the machine specific I2C address
    if [ -z "${machine_i2c_addr}" ]; then
      echo "Warning: I2C address not found for machine: ${MACHINE}"
    else
      sed -i "s/interface = .*/interface = i2c,${machine_i2c_addr}/" ${D}${localstatedir}/lib/cryptoauthlib/0.conf
    fi
}

FILES:${PN} = "${libdir}/* \
	       ${sysconfdir}/cryptoauthlib/cryptoauthlib.conf \
	       ${localstatedir}/lib/cryptoauthlib/slot.conf.tmpl \
	       ${datadir}/p11-kit/modules/cryptoauthlib.module \
	       ${localstatedir}/lib/cryptoauthlib/0.conf \
"
FILES:${PN}-dev = " \
		${includedir}/cryptoauthlib/* \
"

INSANE_SKIP:${PN} += "dev-so"
