DESCRIPTION = "Atmel SAM-BA In-system Programmer"
SECTION = "devel"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://www.microchip.com/content/dam/mchp/documents/MPU32/ProductDocuments/SoftwareTools/${BPN}_${PV}-linux_x86_64.tar.gz"
SRC_URI[md5sum] = "54f9c25b18a2a1afe2735b5da38e7580"
SRC_URI[sha256sum] = "dc32c49688bbfab5aa687042caae5f611fe3d9e722098a561f8f5d2fbc57249d"

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
