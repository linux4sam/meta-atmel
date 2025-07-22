SUMMARY = "Polarfire SoC Linux example applications"
DESCRIPTION = "Linux Example applications, includes the following: \
    - iiohttpserver collects ADC measurements and displays them via a webserver. \
    - LSRAM read and write example. \
    - UIO DMA interrupt example."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=06ec214e9fafe6d4515883d77674a453"

DEPENDS = "openssl"

PV = "1.0+git${SRCPV}"
SRCREV = "v2025.07"
SRC_URI = "git://github.com/polarfire-soc/polarfire-soc-linux-examples.git;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

PACKAGES = " \
    ${PN}-amp \
    ${PN}-can \
    ${PN}-dma \
    ${PN}-dt-overlays \
    ${PN}-gateware \
    ${PN}-lsram \
    ${PN}-pdma \
    ${PN}-system-services \
"

SECURITY_CFLAGS = ""

# Apply INSANE_SKIP flags to all packages listed (alphabetical order)
INSANE_SKIP:${PN}-amp += "file-rdeps ldflags debug-files"
INSANE_SKIP:${PN}-can += "file-rdeps ldflags debug-files"
INSANE_SKIP:${PN}-dma += "file-rdeps ldflags debug-files"
INSANE_SKIP:${PN}-dt-overlays += "file-rdeps ldflags debug-files"
INSANE_SKIP:${PN}-gateware += "file-rdeps ldflags debug-files"
INSANE_SKIP:${PN}-lsram += "file-rdeps ldflags debug-files"
INSANE_SKIP:${PN}-pdma += "file-rdeps ldflags debug-files"
INSANE_SKIP:${PN}-system-services += "file-rdeps ldflags debug-files"

EXAMPLE_FILES = "\
    amp/rpmsg-pingpong \
    amp/rpmsg-tty-example \
    can \
    dma \
    dt-overlays \
    fpga-fabric-interfaces/lsram \
    gateware \
    pdma \
    system-services \
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

FILES:${PN}-amp = "/opt/microchip/amp/rpmsg-pingpong/ /opt/microchip/amp/rpmsg-tty-example/"
FILES:${PN}-can = "/opt/microchip/can/"
FILES:${PN}-dma = "/opt/microchip/dma/"
FILES:${PN}-dt-overlays = "/opt/microchip/dt-overlays/"
FILES:${PN}-gateware = "/opt/microchip/gateware/"
FILES:${PN}-lsram = "/opt/microchip/fpga-fabric-interfaces/lsram/"
FILES:${PN}-pdma = "/opt/microchip/pdma/"
FILES:${PN}-system-services = "/opt/microchip/system-services/"

ALLOW_EMPTY:${PN} = "1"
