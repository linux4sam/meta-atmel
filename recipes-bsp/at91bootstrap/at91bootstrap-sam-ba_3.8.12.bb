require at91bootstrap_${PV}.bb

SRC_URI += "file://0002-Enable-image-download-via-sam-ba.patch"

AT91BOOTSTRAP_IMAGE .= "-sam-ba"
AT91BOOTSTRAP_SYMLINK .= "-sam-ba"

do_deploy () {
	install -d ${DEPLOYDIR}
	install ${S}/binaries/${AT91BOOTSTRAP_BINARY} ${DEPLOYDIR}/${AT91BOOTSTRAP_IMAGE}

	cd ${DEPLOYDIR}
	rm -f ${AT91BOOTSTRAP_SYMLINK}
	ln -sf ${AT91BOOTSTRAP_IMAGE} ${AT91BOOTSTRAP_SYMLINK}
}
