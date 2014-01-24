require u-boot.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

COMPATIBLE_MACHINE = "(sama5d3xek|at91sam9x5ek|at91ariag25)"

RDEPENDS_u-boot = "at91bootstrap"

UBOOT_MACHINE_${MACHINE} = "at91sam9x5ek_mmc_config"
UBOOT_ENTRYPOINT = "0x26f00000"
UBOOT_LOADADDRESS = "0x26f00000"

PR = "r0"

SRC_URI = " \
	git://github.com/linux4sam/u-boot-at91.git;branch=u-boot-2013.07-at91;protocol=git \
	file://0001-at91sam9x5ek-fix-nand-init-for-Linux-2.6.39.patch \
	file://0002-boot-from-mmc.patch \
	file://0003-bootm-support.patch \
	file://0004-write-to-mmc.patch \
	file://uEnv.txt \
"
SRCREV = "${AUTOREV}"

#SRCREV = "0c237b7ec92e78568c71e2633026c45dad693314"
PV = "v2013.07-at91"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#UBOOT_FLAGS = " \
#	-DCONFIG_CMD_FAT \
#	-DCONFIG_CMD_EXT2 \
#	-DCONFIG_CMD_EXT4 \
#	-DCONFIG_CMD_FS_GENERIC \
#	-DCONFIG_CMD_BOOTZ \
#	-DCONFIG_SUPPORT_RAW_INITRD \
#	-DCONFIG_CMD_EXT2_WRITE \
#	-DCONFIG_CMD_EXT4_WRITE \
#	-DCONFIG_CMD_FAT_WRITE \
#	-DCONFIG_FAT_WRITE \
#	-DCONFIG_CMD_SETEXPR \
#	-DCONFIG_CMD_BOOTM \
#"

#do_compile_prepend () {
#	CPPFLAGS="${CPPFLAGS} ${UBOOT_FLAGS}"
#}


# Add uEnv.txt to the deployment files.
do_deploy_append () {
	install ${S}/../uEnv.txt ${DEPLOYDIR}/uEnv.txt
}
