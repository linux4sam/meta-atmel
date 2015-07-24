DESCRIPTION = "Atmel SAM-BA In-system Programmer"
SECTION = "devel"
LICENSE = "ATMEL_LLA_SAM-BA"

LIC_FILES_CHKSUM = "file://doc/license.txt;md5=1d90164463a7334a802991ec50f5d2f2"

SRC_URI = "http://www.atmel.com/dyn/resources/prod_documents/sam-ba_${PV}.zip"
SRCREV = "2d35e98539c0daa2bc8049e3bd44994d3d93bbe7"

S = "${WORKDIR}/sam-ba_cdc_linux"

do_install () {
    install -d ${D}${bindir}/sam-ba_cdc_linux
    cp -pPrf ${S}/* ${D}${bindir}/sam-ba_cdc_linux
}

INSANE_SKIP_${PN} += "already-stripped"
BBCLASSEXTEND = "native nativesdk"
