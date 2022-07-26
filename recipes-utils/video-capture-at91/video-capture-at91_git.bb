DESCRIPTION = "Collection of scripts for configuring AT91 video capture pipeline"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=12c44f58fe16bd407f016e45950c2f3d"

SRC_URI = "git://github.com/linux4sam/video-capture-at91.git;protocol=https;branch=master \
          "
COMPATIBLE_MACHINE = "sama7g5ek"

PV = "1.0+git${SRCPV}"
SRCREV = "9cbeed745ab98f1a847e349beb30ac16c0d1ca08"

S = "${WORKDIR}/git"

do_install () {
	for SOC in $(echo ${SOC_FAMILY} | tr ":" "\n")
	do
		install -d ${D}${ROOT_HOME}/video-capture-at91
		cp -r ${S}/${SOC}/* ${D}${ROOT_HOME}/video-capture-at91/ || true
	done
}

FILES_${PN} += "${ROOT_HOME}"
