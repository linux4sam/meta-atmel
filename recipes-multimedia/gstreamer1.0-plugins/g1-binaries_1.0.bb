DESCRIPTION = "Hantro binaries"
LICENSE = "ATMEL_LLA"

LIC_FILES_CHKSUM = "file://include/basetype.h;endline=18;md5=45a908b058dc0c5d75d5501bb331fb60"

PR = "r1"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/g1-binaries-${PV}.tar.gz"

SRC_URI[md5sum] = "5a5a205618d78d6dd9295ab4faa36b19"
SRC_URI[sha256sum] = "1ffec80f0d388b6bdcb2846424ec3efdf504a9f0c6bbcbea30efa4a0c80577bc"
S = "${WORKDIR}/g1-binaries-${PV}"

do_install() {
	install -d ${D}/usr/include
	install -d ${D}/usr/lib
	cp ${S}/include/* ${D}/usr/include/
	cp ${S}/lib/* ${D}/usr/lib/
}

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_DEFAULT_DEPS = "1"
