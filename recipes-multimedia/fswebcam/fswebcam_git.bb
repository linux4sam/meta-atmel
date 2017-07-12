DESCRIPTION = "Webcam image grabber and manipulation application."
SECTION = "graphics"
HOMEPAGE = "http://www.sanslogic.co.uk/fswebcam/"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS = "gd"

PR = "r0"

inherit autotools-brokensep

SRCREV="c417cd8588f93f3f6c4fc687c2cb8f0f9d70b9b0"
SRC_URI = "git://github.com/fsphil/fswebcam.git;protocol=git"

S = "${WORKDIR}/git"
