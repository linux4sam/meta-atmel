DESCRIPTION = "Google noto fonts"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/OFL-1.1;md5=fac3a519e5e9eb96316656e0ca4f2b90"

PR = "2017-10-24"

SRC_URI = "https://noto-website-2.storage.googleapis.com/pkgs/Noto-unhinted.zip"

SRC_URI[md5sum] = "d26b29b10c3c8d05df4ade8286963722"
SRC_URI[sha256sum] = "7d0e099c208d11d7bf64091ea7f62f85bc07dedfaf2c01de53985a5b981025e3"

S = "${WORKDIR}/"

FILES_${PN} += " \
    /usr/share/fonts/noto/* \
"
do_install() {
        install -d ${D}/usr/share/fonts/noto
        cp -Rf ${S}/NotoSans-Regular.ttf ${D}/usr/share/fonts/noto
        cp -Rf ${S}/NotoSansCJKsc-Regular.otf ${D}/usr/share/fonts/noto
        cp -Rf ${S}/NotoColorEmoji.ttf ${D}/usr/share/fonts/noto
}

ALLOW_EMPTY_${PN} = "1"
INHIBIT_DEFAULT_DEPS = "1"
