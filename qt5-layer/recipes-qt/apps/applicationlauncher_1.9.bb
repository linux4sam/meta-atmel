require applicationlauncher.inc

SRC_URI[md5sum] = "36ab929837a1dc259261c01677a25ee2"
SRC_URI[sha256sum] = "a7ff09eff3aea42cdde61292f76a456916694c0d80f91208bf6ed52d7328e07c"

SRC_URI_append_sama5d4 += " file://applicationlauncher_videoplayer.patch"
