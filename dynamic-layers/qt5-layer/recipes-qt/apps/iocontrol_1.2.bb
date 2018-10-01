DESCRIPTION = "Microchip I/O Control Application"
LICENSE = "(GPLv3 & MIT)"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                   file://LICENSE.MIT;md5=bc47140df2dfc4ee5df97fde106921f7"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "mpio qtbase"

RDEPENDS_${PN} = "python"

SRC_URI = "git://github.com/linux4sam/iocontrol.git;protocol=https"
PV = "1.2+git${SRCPV}"
SRCREV = "125947445d537fd940cb7bfdb38de3a6a5a26c05"

S = "${WORKDIR}/git"

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
