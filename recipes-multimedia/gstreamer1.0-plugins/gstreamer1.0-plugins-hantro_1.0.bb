include gstreamer1.0-plugins-hantro.inc

LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=bb3ca60759f3202f1ae42e3519cd06bc \
		   "
PR = "r1"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/gst-hantro-g1-${PV}.tar.gz"
SRC_URI += "file://0001-g1-hantro-plugin-enable-RGB-dithering-for-PostProces.patch"
SRC_URI += "file://0002-fix-configure.ac.patch"

SRC_URI[md5sum] = "07bb4dfc47efd2ec91e1dedeac90ebf3"
SRC_URI[sha256sum] = "c2ac7fe6df1ce9bdf9f570bf17d656bbf755b50d4b5f19833e1cf6894e44bccb"

S = "${WORKDIR}/gst-hantro-g1-${PV}"

