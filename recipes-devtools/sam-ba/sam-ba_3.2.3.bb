DESCRIPTION = "Atmel SAM-BA In-system Programmer"
SECTION = "devel"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://github.com/atmelcorp/${BPN}/releases/download/v${PV}/${BPN}_${PV}-linux_x86_64.tar.gz"
SRC_URI[md5sum] = "11746fcc1f97e054fa6a8c9c57c12a20"
SRC_URI[sha256sum] = "3ecd53dab9a60debe5a861e272e095da008300c860ce7494102ad987eea7c8e9"

inherit deploy

S = "${WORKDIR}/${BPN}_${PV}"

do_install () {
    install -d ${D}${bindir}/sam-ba_cdc_linux
    cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${bindir}/sam-ba_cdc_linux
}

addtask deploy after do_install

do_deploy () {
        install -d ${DEPLOYDIR}/sam-ba
        cp -R --no-dereference --preserve=mode,links ${D}${bindir}/sam-ba_cdc_linux/* ${DEPLOYDIR}/sam-ba
}

INSANE_SKIP_${PN} += "already-stripped"
BBCLASSEXTEND = "native nativesdk"

COMPATIBLE_HOST_class-target = "null"
