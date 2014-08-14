include gstreamer1.0-plugins-hantro.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c \
                    "

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/qtdemo/gst-hantro-g1-${PV}.tar.gz"

SRC_URI[md5sum] = "4bd5d6488536ecfacda4ed98b83656f7"
SRC_URI[sha256sum] = "ad3b1b44c5c61845a1318b7846e815e810e7d014938bb62f59b84f4a5a7447df"

S = "${WORKDIR}/gst-hantro-g1-${PV}"

