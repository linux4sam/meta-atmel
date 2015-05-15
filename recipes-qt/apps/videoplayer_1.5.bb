require videoplayer.inc

SRC_URI[md5sum] = "1956b3e2234107fda908fd0d73bf33a2"
SRC_URI[sha256sum] = "72fb707b0bc71c006a38d14c9b7c918cb0edd54756c1e820b52dad12ec7e77c5"

SRC_URI += "file://videoplayer-gstreamer-no-fb1.patch"
SRC_URI += "file://videoplayer-gst-launch-adapt-screen.patch"
