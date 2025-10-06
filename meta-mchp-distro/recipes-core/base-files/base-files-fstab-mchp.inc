FILESEXTRAPATHS:prepend:autoresize := "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '${THISDIR}/files:', '', d)}"
