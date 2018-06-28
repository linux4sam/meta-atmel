SUMMARY = "Hantro plugins for GStreamer"
SECTION = "multimedia"
LICENSE = "LGPLv2.1"
HOMEPAGE = "http://www.gstreamer.net/"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base g1-decoder"

inherit autotools-brokensep pkgconfig gettext

LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "libdrm"

S = "${WORKDIR}/git"
SRC_URI = "gitsm://github.com/linux4sam/gst1-hantro-g1;branch=master"

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-1.0/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-1.0/*.a"
