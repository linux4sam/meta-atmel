DESCRIPTION = "Hantro binaries"
LICENSE = "ATMEL_LLA"

LIC_FILES_CHKSUM = "file://include/basetype.h;endline=18;md5=45a908b058dc0c5d75d5501bb331fb60"

PR = "r1"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/g1-binaries-${PV}.tar.gz"

SRC_URI[md5sum] = "2111d0307fcd3197cf3372437a721384"
SRC_URI[sha256sum] = "f6def1ae8961ea6715e95f7f797156d949445ad353c5f02c9814b5345d1439f0"

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
