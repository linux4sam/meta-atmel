DESCRIPTION = "EGT media files from video demo"
LICENSE = "CLOSED"

PR = "r1"

SRC_URI = "ftp://www.at91.com/pub/demo/media/egt-media-${PV}.tar.gz"

SRC_URI[md5sum] = "1cf0df233a15b120be582f4472be00bb"

S = "${WORKDIR}/examples"

FILES_${PN} += " \
    /usr/share/egt/* \
"
do_install() {
	install -d ${D}/usr/share/egt/examples
	cp -Rf ${S}/* ${D}//usr/share/egt/examples/
}

ALLOW_EMPTY_${PN} = "1"
INHIBIT_DEFAULT_DEPS = "1"
