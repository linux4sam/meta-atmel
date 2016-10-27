SUMMARY = "Atmel wilc1000 firmware files for use with Linux kernel"
SECTION = "kernel"

LICENSE = "CLOSED"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/linux4sc/wireless-firmware.git;protocol=git;branch=v14 "
S = "${WORKDIR}/git"

inherit allarch

do_compile() {
	:
}

do_install() {
	install -d  ${D}/lib/firmware/atmel/
	cp -r * ${D}/lib/firmware/atmel/

	# remove unneeded file
	rm -f ${D}/lib/firmware/atmel/README.md
	rm -rf ${D}/lib/firmware/atmel/tools
	chmod -x ${D}/lib/firmware/atmel/*
}


FILES_${PN} = " \
  /lib/firmware/atmel/wilc100*_*.bin \
"
# TODO: use ALTERNATIVE like in "linux-firmware" package
