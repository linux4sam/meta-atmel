DESCRIPTION = "Webcam image grabber and manipulation application."
SECTION = "graphics"
HOMEPAGE = "http://www.sanslogic.co.uk/fswebcam/"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS = "gd"

PR = "r0"

inherit autotools

SRCREV="a0a35da8cf0a5d6a257191fffb11c25311d948e9"
SRC_URI = "git://github.com/fsphil/fswebcam.git;protocol=git"

S = "${WORKDIR}/git"
