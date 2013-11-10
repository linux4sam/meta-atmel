require recipes-devtools/qemu/qemu.inc

LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f25bdedb882776236331100434d162f"
SRC_URI[sha256sum] = "fc736f44aa10478223c881310a7e40fc8386547e9cadf7d01ca4685951605294"
SRC_URI = "http://wiki.qemu-project.org/download/qemu-1.6.1.tar.bz2 \
	file://powerpc_rom.bin \
	"

EXTRA_OECONF = "--target-list=${@get_qemu_target_list(d)} --disable-werror --d\
isable-vnc-tls --audio-drv-list=oss,alsa ${SDL} -\
-disable-curl --disable-vnc-jpeg --disable-bluez --with-system-pixman"

#do_fetch () {
#	exit 0
#}

#do_unpack () {
#	exit 0
#}

#do_patch () {
#	exit 0
#}

#do_configure () {
#	exit 0
#}

#do_qa_configure () {
#	exit 0
#}

#do_compile () {
#	exit 0
#}

#do_install () {
#	exit 0
#}
