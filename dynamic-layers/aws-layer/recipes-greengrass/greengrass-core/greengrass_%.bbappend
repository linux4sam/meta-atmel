# do not start Greenrass at boot
INITSCRIPT_PARAMS = "disable"

# packets recommended for Microchip CryptoAuthentication devices
RRECOMMENDS_${PN} = " cryptoauthlib python3-cryptoauthlib p11-kit"
