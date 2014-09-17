SUMMARY = "Hantro plugins for GStreamer"
SECTION = "multimedia"
LICENSE = "LGPLv2.1"
LICENSE_FLAGS = "commercial"
HOMEPAGE = "http://www.gstreamer.net/"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base g1-binaries"

inherit autotools pkgconfig gettext

//acpaths = "-I ${S}/common/m4 -I ${S}/m4"


FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-1.0/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-1.0/*.a"

