LICENSE += "& Firmware-atmel"
LIC_FILES_CHKSUM += "file://LICENSE.atmel;md5=aa74ac0c60595dee4d4e239107ea77a3"

NO_GENERIC_LICENSE[Firmware-atmel] = "LICENSE.atmel"
LICENSE_${PN}-atmel = "Firmware-atmel"

PACKAGES =+ "${PN}-atmel ${PN}-atmel-license"

FILES_${PN}-atmel-license = "/lib/firmware/LICENSE.atmel"
FILES_${PN}-atmel = "/lib/firmware/atmel/* "

RDEPENDS_${PN}-atmel += "${PN}-atmel-license"
