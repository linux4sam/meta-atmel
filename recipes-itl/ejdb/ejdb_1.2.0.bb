SUMMARY="This recipe installs the EJDB database"
HOMEPAGE="http://ejdb.org"
LICENSE="LGPL"
LIC_FILES_CHKSUM="file://ejdb/LICENSE;md5=ade9a053df81f5b9408d2f4f5546df86"

SRC_URI="file://ejdb_ARM_1.2.tar.gz"
S = "${WORKDIR}"

DEPENDS="zlib"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/ejdb/bin/jbbmgr ${D}${bindir}/jbbmgr
	install -m 0755 ${WORKDIR}/ejdb/bin/jbfmgr ${D}${bindir}/jbfmgr
	install -m 0755 ${WORKDIR}/ejdb/bin/jbhmgr ${D}${bindir}/jbhmgr
	install -m 0755 ${WORKDIR}/ejdb/bin/jbtmgr ${D}${bindir}/jbtmgr

	install -d ${D}${includedir}
	cp -r ${WORKDIR}/ejdb/include/ejdb ${D}${includedir} 

	install -d ${D}${libdir}
	cp -r ${WORKDIR}/ejdb/lib/* ${D}${libdir}

}


