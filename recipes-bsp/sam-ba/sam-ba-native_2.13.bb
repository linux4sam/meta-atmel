SUMMARY="The SAM Boot Assistant (SAM-BA) software provides a means of easily \
programming different Atmel AT91SAM devices. "
HOMEPAGE="http://www.atmel.com/tools/atmelsam-bain-systemprogrammer.aspx"
LICENSE="Proprietary"

LIC_FILES_CHKSUM="file://doc/README.linux;md5=2a0ec10b79bc2b844906bbd28d7b8c6e"

SRC_URI = "http://www.atmel.com/dyn/resources/prod_documents/${BPN}_${PV}.zip"
SRC_URI[md5sum] = "10bb60c2f8c7a54cbce90251d5872f32"
SRC_URI[sha256sum] = "74a618d7efd0e2de4ac60321f9fba6e636b29af337b38d8ccd83d41ccb04c546"


S = "${WORKDIR}/sam-ba_cdc_linux"

do_install() {
	install -d ${D}${libexecdir}
	cp -ra ${S}/* ${D}${libexecdir}
	install -m 0755 ${S}/sam-ba ${D}${libexecdir}/sam-ba
	install -d ${D}${bindir}
	(cd  ${D}${bindir}; ln -s ${D}${libexecdir}/sam-ba)
}

inherit native
