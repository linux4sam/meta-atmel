SUMMARY = "Python Wrapper Library for Microchip Security Products"
HOMEPAGE = "https://github.com/MicrochipTech/cryptoauthlib"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "https://files.pythonhosted.org/packages/10/45/b1807202a7b73be97b0d68ce74bbeb84da1c165a5119eddcba8cc4315e1e/cryptoauthlib-${PV}.tar.gz \
           ${PYPI_SRC_URI} \
           "
SRC_URI[md5sum] = "d62edc97f9a12ad4aa48cb89257c3894"
SRC_URI[sha256sum] = "07c5f358219af4ac23de74ba1bbb8dd754d19c041dd09dea8504eacfd20b8c80"

inherit pypi setuptools3

RDEPENDS_${PN} += "python3-core python3-cryptography python3-ctypes python3-datetime python3-netclient"

DEPENDS += "cmake-native"
