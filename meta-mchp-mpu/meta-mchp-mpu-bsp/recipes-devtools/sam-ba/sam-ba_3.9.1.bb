DESCRIPTION = "Microchip SAM-BA In-system Programmer"
SECTION = "devel"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://github.com/atmelcorp/${BPN}/releases/download/v${PV}/${BPN}_v${PV}-linux_x86_64.tar.gz"
SRC_URI[md5sum] = "e2058ce25e6af072deff407ac57b443d"
SRC_URI[sha256sum] = "59b77ae4b716aed4d9ffdbbf707f3f414f80da8357a42a1409d8740d7387e567"

S = "${WORKDIR}/${BPN}_v${PV}"

do_install () {
    install -d ${D}${bindir}/
    cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${bindir}/
}

INSANE_SKIP:${PN} += "already-stripped"
BBCLASSEXTEND = "native nativesdk"

COMPATIBLE_HOST:class-target = ""
