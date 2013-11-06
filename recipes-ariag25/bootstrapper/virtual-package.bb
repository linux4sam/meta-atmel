DESCRIPTION = "Virtual package that serves to install a number of other packages"
LIC_FILES_CHKSUM = "file://LICENSE;md5="

SRC_URI = "file://LICENSE"
S = "${WORKDIR}"

ALLOW_EMPTY_${PN} = "1"
PR = "r0"

# Add packages here.
RDEPENDS_${PN} = " \
"
