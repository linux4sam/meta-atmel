DESCRIPTION = "Lohit Indic fonts"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/OFL-1.1;md5=fac3a519e5e9eb96316656e0ca4f2b90"

SRC_URI = "https://releases.pagure.org/lohit/lohit-ttf-20140220.tar.gz"

SRC_URI[md5sum] = "aee81313dae1a8fb6ed3a4f572180c42"
SRC_URI[sha256sum] = "4d0cdb884cb30b8e11babf2266a189e173bd9d664878ee434136705808c9afe6"

S = "${WORKDIR}/lohit-ttf-20140220"

inherit allarch fontcache

FILES_${PN} += " \
    ${datadir}/fonts/truetype/* \
"

do_install() {
        install -d ${D}${datadir}/fonts/truetype/lohit-devanagari
        install -Dm 0644 ${S}/Lohit-Devanagari.ttf ${D}${datadir}/fonts/truetype/lohit-devanagari
}

do_compile[noexec] = "1"

ALLOW_EMPTY_${PN} = "1"
INHIBIT_DEFAULT_DEPS = "1"
