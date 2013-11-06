ANGSTROM_URI = "http://opkg.blazingangles.com"
FEED_BASEPATH = "stable"

EXTRA_ARCHS_${PN} = "all armv5te arm926ejste at91ariag25"

FILES_${PN} = "${sysconfdir}/opkg/base-feed.conf"

do_compile() {
    mkdir -p ${S}/${sysconfdir}/opkg

    for feed in ${EXTRA_ARCHS_${PN}}; do
    	echo "src/gz ${feed} ${ANGSTROM_URI}/${FEED_BASEPATH}/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
  	done

  	echo "src/gz base ${ANGSTROM_URI}/${FEED_BASEPATH}" > ${S}/${sysconfdir}/opkg/base-feed.conf
}


FILES_${PN} += "\
	${sysconfdir}/opkg/all-feed.conf \
	${sysconfdir}/opkg/armv5te-feed.conf \
	${sysconfdir}/opkg/arm926ejste-feed.conf \
	${sysconfdir}/opkg/at91ariag25-feed.conf \
"
