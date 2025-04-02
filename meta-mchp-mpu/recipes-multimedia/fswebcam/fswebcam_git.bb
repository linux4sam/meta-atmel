DESCRIPTION = "Webcam image grabber and manipulation application."
SECTION = "graphics"
HOMEPAGE = "http://www.sanslogic.co.uk/fswebcam/"
LICENSE="GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS = "gd"

PR = "r0"

inherit autotools-brokensep

SRCREV="db35d4bbd336885a44f017ff142bc9523dbdce3c"
SRC_URI = "git://github.com/fsphil/fswebcam.git;protocol=https;branch=master"

S = "${WORKDIR}/git"
