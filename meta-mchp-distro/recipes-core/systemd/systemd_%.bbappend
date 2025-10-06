require ${@bb.utils.contains('MCHP_FEATURES', 'mchp-autoresize', '${BPN}-repart-mchp.inc', '', d)}
