DESCRIPTION = "Hantro binaries"
LICENSE = "ATMEL_LLA"

LIC_FILES_CHKSUM = "file://include/basetype.h;endline=18;md5=45a908b058dc0c5d75d5501bb331fb60"

PR = "r1"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/g1-binaries-${PV}.tar.gz"

SRC_URI[md5sum] = "5f30a3dcadce213448a2815493221812"
SRC_URI[sha256sum] = "f0288c84fb3e07ab18037c12b2070128176cd9ab7ae54ae2627ff904c28e06b3"
S = "${WORKDIR}/g1-binaries-${PV}"

do_install() {
	install -d ${D}/usr/include
	install -d ${D}/usr/lib
	cp ${S}/include/* ${D}/usr/include/
	cp ${S}/lib/* ${D}/usr/lib/
}

ALLOW_EMPTY_${PN} = "1"
INHIBIT_DEFAULT_DEPS = "1"
COMPATIBLE_MACHINE = "sama5d4"
