DESCRIPTION = "Webcam image grabber and manipulation application."
SECTION = "graphics"
HOMEPAGE = "http://www.sanslogic.co.uk/fswebcam/"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS = "gd"

PR = "r0"

inherit autotools-brokensep

SRCREV="e9f8094b6a3d1a49f99b2abec4e6ab4df33e2e33"
SRC_URI = "git://github.com/fsphil/fswebcam.git;protocol=git"

S = "${WORKDIR}/git"
