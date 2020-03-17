LICENSE = "CLOSED"
SRC_URI = "git://github.com/MicrochipTech/cryptoauthlib.git;branch=pkcs11;protocol=https \
                    file://0001-Changed-I2C-bus-to-bus-0.patch"

PV = "1.0+git${SRCPV}"
SRCREV = "2df0eb145c7241263d07577394dd12f8b1e783f0"

S = "${WORKDIR}/git"

DEPENDS = "eudev"
RDEPENDS_${PN} = "libp11 (>= 0.4.10) gnutls-bin"
RRECOMMENDS_${PN} = "p11-kit"

inherit cmake

EXTRA_OECMAKE = ""

FILES_${PN} = "/usr/lib/libcryptoauth.so /etc/cryptoauthlib/cryptoauthlib.conf /var/lib/cryptoauthlib/slot.conf.tmpl"
FILES_${PN}-dev = ""
