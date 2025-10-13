SUMMARY = "PIC64GX Linux Example Applications"
DESCRIPTION = "Linux Example Applications"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=06ec214e9fafe6d4515883d77674a453"

PV = "1.0+git${SRCPV}"
SRCREV="ff749ffb982b601f2cc99a53566511711dca65f5"
SRC_URI = "git://github.com/pic64gx/pic64gx-linux-examples.git;protocol=https;nobranch=1 \
          "

S = "${WORKDIR}/git"

PACKAGES = " \
    ${PN}-amp \
    ${PN}-dt-overlays \
"

SECURITY_CFLAGS = ""

# Apply INSANE_SKIP flags to all packages listed (alphabetical order)
INSANE_SKIP:${PN}-amp += "file-rdeps ldflags debug-files"
INSANE_SKIP:${PN}-dt-overlays += "file-rdeps ldflags debug-files"


EXAMPLE_FILES = "\
    dt-overlays \
    amp/rpmsg-pingpong \
    amp/rpmsg-tty-example \
    "

do_compile() {
    for i in ${EXAMPLE_FILES}; do
        if [ -f ${S}/$i/Makefile ]; then
        oe_runmake -C ${S}/$i
        fi
    done
}


do_install() {
    install -d ${D}/opt/microchip
    chmod a+x ${D}/opt/microchip

    for i in ${EXAMPLE_FILES}; do
        install -d ${D}/opt/microchip/$(dirname $i)/$(basename $i)
        cp -rfd ${S}/$i ${D}/opt/microchip/$(dirname $i)
    done
}

FILES:${PN}-amp += "/opt/microchip/amp"
FILES:${PN}-dt-overlays = "/opt/microchip/dt-overlays/"

ALLOW_EMPTY:${PN} = "1"
