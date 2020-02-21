SUMMARY = "Microchip WILC devices firmware files for use with Linux kernel"
SECTION = "kernel"
LICENSE = "MICROCHIP_FW"

LIC_FILES_CHKSUM = "file://LICENSE.wilc_fw;beginline=6;md5=e1a0446d046c966a27276cf8e728f687"

SRCREV = "wilc_linux_15_3_1"
SRC_URI = "git://github.com/linux4wilc/firmware.git;protocol=https"
S = "${WORKDIR}/git"

inherit allarch

do_install() {
	install -d ${D}/lib/firmware/mchp/
	cp -r ${S}/* ${D}/lib/firmware/mchp/

	# remove unneeded file
	rm -f ${D}/lib/firmware/mchp/README.md
	rm -f ${D}/lib/firmware/mchp/LICENSE.wilc_fw
	chmod -x ${D}/lib/firmware/mchp/*
}


FILES_${PN} += " \
	${base_libdir}/firmware/mchp/wilc*.bin \
	"

# TODO: use ALTERNATIVE like in "linux-firmware" package
