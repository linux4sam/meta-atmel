DESCRIPTION = "Google noto fonts"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/OFL-1.1;md5=fac3a519e5e9eb96316656e0ca4f2b90"

PR = "2025-01-19"

SRC_URI = " \
    https://github.com/notofonts/notofonts.github.io/raw/main/fonts/NotoSans/unhinted/ttf/NotoSans-Regular.ttf;name=notosans \
    https://github.com/notofonts/noto-cjk/raw/main/Sans/OTF/SimplifiedChinese/NotoSansCJKsc-Regular.otf;name=notosanssc \
    https://github.com/googlefonts/noto-emoji/raw/main/fonts/NotoColorEmoji.ttf;name=notoemoji \
"
S = "${WORKDIR}"

SRC_URI[notosans.sha256sum] = "f3961a9cde016d41a4879aecda1474d3a36d6bf54fa0e4643de029cc2248b0e8"
SRC_URI[notosanssc.sha256sum] = "2c76254f6fc379fddfce0a7e84fb5385bb135d3e399294f6eeb6680d0365b74b"
SRC_URI[notoemoji.sha256sum] = "72a635cb3d2f3524c51620cdde406b217204e8a6a06c6a096ff8ed4b5fd6e27b"

inherit allarch fontcache

FILES:${PN} += " \
    ${datadir}/fonts/noto/* \
"

do_install() {
        install -Dm 0644 ${S}/NotoSans-Regular.ttf ${D}${datadir}/fonts/noto/NotoSans-Regular.ttf
        install -Dm 0644 ${S}/NotoSansCJKsc-Regular.otf ${D}${datadir}/fonts/noto/NotoSansCJKsc-Regular.otf
        install -Dm 0644 ${S}/NotoColorEmoji.ttf ${D}${datadir}/fonts/noto/NotoColorEmoji.ttf
}

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
INHIBIT_DEFAULT_DEPS = "1"
