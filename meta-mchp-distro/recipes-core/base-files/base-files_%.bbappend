require ${@bb.utils.contains('MCHP_FEATURES', 'mchpcore', '${BPN}-motd-mchp.inc', '', d)}

MCHP_FSTAB:autoresize = "${@bb.utils.contains('MCHP_FEATURES', 'mchp-autoresize', '${BPN}-fstab-mchp.inc', '', d)}"
MCHP_FSTAB = ""
require ${MCHP_FSTAB}
