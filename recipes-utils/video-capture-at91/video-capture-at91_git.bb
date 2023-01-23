DESCRIPTION = "Collection of scripts for configuring AT91 video capture pipeline"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=12c44f58fe16bd407f016e45950c2f3d"

SRC_URI = "git://github.com/linux4sam/video-capture-at91.git;protocol=https;branch=sam9x7_early \
          "
COMPATIBLE_MACHINE = "sam9x75eb|sama7g5ek|sama5d2"

PV = "1.0+git${SRCPV}"
SRCREV = "882ede15dd4aec22728b1883f253ade3f25a65c6"

S = "${WORKDIR}/git"

do_install () {
	for SOC in $(echo ${SOC_FAMILY} | tr ":" "\n")
	do
		install -d ${D}${ROOT_HOME}/video-capture-at91
		cp -r ${S}/${SOC}/* ${D}${ROOT_HOME}/video-capture-at91/ || true
	done
}

FILES:${PN} += "${ROOT_HOME}"
