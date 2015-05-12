SUMMARY = "Atmel wilc1000 firmware files for use with Linux kernel"
SECTION = "kernel"

LICENSE = "CLOSED"

SRCREV = "${AUTOREV}"
PV = "0.0+git${SRCPV}"

SRC_URI = "git://github.com/linux4sc/wireless-firmware.git;protocol=git \
          "
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
	chmod -x ${D}/lib/firmware/atmel/*
}


FILES_${PN} = " \
  /lib/firmware/atmel/wilc1000_*.bin \
"
# TODO: use ALTERNATIVE like in "linux-firmware" package
