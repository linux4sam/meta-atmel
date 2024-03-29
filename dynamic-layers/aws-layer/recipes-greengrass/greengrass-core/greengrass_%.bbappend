# do not start Greenrass at boot
INITSCRIPT_PARAMS = "disable"

# we remove these dependencies since we do not aim all the features of GG
RDEPENDS:${PN}:remove = "docker python3-docker-compose openjdk-8"

# packets recommended for Microchip CryptoAuthentication devices
RRECOMMENDS:${PN} = " cryptoauthlib python3-cryptoauthlib p11-kit"
