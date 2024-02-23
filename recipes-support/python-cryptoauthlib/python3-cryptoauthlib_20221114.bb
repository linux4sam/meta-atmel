SUMMARY = "Python Wrapper Library for Microchip Security Products"
HOMEPAGE = "https://github.com/MicrochipTech/cryptoauthlib"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

inherit pypi setuptools3

SRC_URI += "file://0001-correct-the-python_requires-version-syntax.patch \
            file://0001-atca_iface.h-Fix-function-mismatches-in-function-poi.patch"
SRC_URI[sha256sum] = "cc63dba63f1983c12ad18ecb3f1595083feffc0cb827d2a8d3a54c850d26ed5d"

RDEPENDS:${PN} += "python3-core python3-cryptography python3-ctypes python3-datetime python3-netclient"

DEPENDS += "cmake-native udev"

export CRYPTOAUTHLIB_NOUSB = "True"
