require ${@bb.utils.contains('MCHP_FEATURES', 'mchp-autoresize', '${BPN}-repart-mchp.inc', '', d)}
require ${@bb.utils.contains('MCHP_FEATURES', 'mchp-strip-systemd', '${BPN}-strip-mchp.inc', '', d)}
