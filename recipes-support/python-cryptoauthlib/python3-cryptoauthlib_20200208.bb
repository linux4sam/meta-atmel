SUMMARY = "Python Wrapper Library for Microchip Security Products"
HOMEPAGE = "https://github.com/MicrochipTech/cryptoauthlib"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "https://files.pythonhosted.org/packages/1b/ed/da1709095abd203e37892f7183b68433382ce6a0f6129dfa0ac47e2ba85c/cryptoauthlib-${PV}.tar.gz \
           ${PYPI_SRC_URI} \
           "
SRC_URI[md5sum] = "3a464cb6ea78286353870e544f85e208"
SRC_URI[sha256sum] = "7b04a4097c6f8d4b539c7425261eac3353016405b863fec2d827152ce3a652bf"

inherit pypi setuptools3

RDEPENDS_${PN} += "python3-core python3-cryptography python3-ctypes python3-datetime python3-netclient"

DEPENDS += "cmake-native ${@bb.utils.contains('DISTRO_FEATURES','systemd','udev','eudev',d)}"

export CRYPTOAUTHLIB_NOUSB = "True"
