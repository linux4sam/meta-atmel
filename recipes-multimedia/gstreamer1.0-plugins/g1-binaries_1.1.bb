DESCRIPTION = "Hantro binaries"
LICENSE = "ATMEL_LLA"

LIC_FILES_CHKSUM = "file://include/basetype.h;endline=18;md5=45a908b058dc0c5d75d5501bb331fb60"

PR = "r1"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/g1-binaries-${PV}.tar.gz"

SRC_URI[md5sum] = "b933d0449b07a64c5cb0a9e9ce3eacd0"
SRC_URI[sha256sum] = "1de8d4e5d894e8ea9a21e40e10e6b3fdfdfdfd135dcc2d0acbe810ecf8abc3de"
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
