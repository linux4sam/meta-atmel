require ${@bb.utils.contains('MCHP_FEATURES', 'mchpcore', '${BPN}-mchp.inc', '', d)}
