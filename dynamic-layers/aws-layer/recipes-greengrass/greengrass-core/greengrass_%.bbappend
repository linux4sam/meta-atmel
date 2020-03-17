# do not start Greenrass at boot
INITSCRIPT_PARAMS = "disable"

# packets recommended for Microchip CryptoAuthentication devices
RRECOMMENDS_${PN} = " cryptoauthlib python-cryptoauthlib p11-kit"
