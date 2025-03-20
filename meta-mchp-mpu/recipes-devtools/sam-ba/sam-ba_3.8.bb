DESCRIPTION = "Microchip SAM-BA In-system Programmer"
SECTION = "devel"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://github.com/atmelcorp/${BPN}/releases/download/v${PV}/${BPN}_v${PV}-linux_x86_64.tar.gz"
SRC_URI[md5sum] = "b2d0eb543fedc0e6fc3e5fc971eacdb1"
SRC_URI[sha256sum] = "22b362271815dad7666478d1c6cb20a111cdcbf2c82c81a63d553a00d6c92a0c"

S = "${WORKDIR}/${BPN}_v${PV}"

do_install () {
    install -d ${D}${bindir}/
    cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${bindir}/
}

INSANE_SKIP:${PN} += "already-stripped"
BBCLASSEXTEND = "native nativesdk"

COMPATIBLE_HOST:class-target = ""
