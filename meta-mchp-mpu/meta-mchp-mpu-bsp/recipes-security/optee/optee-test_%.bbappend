OPTEE_MCHP_VERSION = ""
OPTEE_MCHP_VERSION:sama5d27-som1-ek-optee-sd = "${BPN}-mchp-version.inc"
OPTEE_MCHP_VERSION:sama7g5ek-optee-sd = "${BPN}-mchp-version.inc"

require ${OPTEE_MCHP_VERSION}
