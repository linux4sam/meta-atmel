DESCRIPTION = "Microchip I/O Control Application"
LICENSE = "(GPLv3 & MIT)"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                   file://LICENSE.MIT;md5=bc47140df2dfc4ee5df97fde106921f7"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "mpio qtbase"

RDEPENDS_${PN} = "python"

SRC_URI = "https://github.com/linux4sam/iocontrol/archive/v${PV}.tar.gz;downloadfilename=iocontrol-${PV}.tar.gz"

SRC_URI[md5sum] = "aa500d922a14cdd92d0ef1bf28e9cc92"
SRC_URI[sha256sum] = "e5b5d74af7a1c3594ea951edd1fc1a457854393b6a72c79aeaa8ebd4f6141a26"

S = "${WORKDIR}/iocontrol-${PV}"

inherit setuptools

FILES_${PN} += " \
	/opt/ApplicationL* \
	/opt/iocontrol/iocontrol.sh \
	/opt/iocontrol \
   "

do_install_append() {
	install -Dm 0644 ${S}/res/iocontrol.png \
				${D}/opt/ApplicationLauncher/applications/resources/iocontrol.png
	install -Dm 0644 ${S}/res/08-iocontrol.xml \
                ${D}/opt/ApplicationLauncher/applications/xml/08-iocontrol.xml
	install -Dm 0755 ${S}/res/iocontrol.sh \
                ${D}/opt/iocontrol/iocontrol.sh
}
