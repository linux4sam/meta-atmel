require u-boot.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

COMPATIBLE_MACHINE = "(sama5d3xek|at91sam9x5ek|at91ariag25)"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
#UBOOT_MACHINE_${MACHINE} = "${MACHINE}_mmc_config"
UBOOT_MACHINE_${MACHINE} = "at91sam9x5ek_mmc_config"
UBOOT_ENTRYPOINT = "0x26f00000"
UBOOT_LOADADDRESS = "0x26f00000"

# This revision corresponds to the tag "v2013.07"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "0c237b7ec92e78568c71e2633026c45dad693314"

PV = "v2013.07-at91"
PR = "r0"

SRC_URI = " \
                git://github.com/linux4sam/u-boot-at91.git;branch=u-boot-2013.07-at91;protocol=git \
                file://0001-at91sam9x5ek-fix-nand-init-for-Linux-2.6.39.patch \
                file://0002-boot-from-mmc.patch \
                file://0003-bootm-support.patch \
                file://uEnv.txt \
                "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Add the uEnv.txt to the deployment files.
do_deploy_append () {
        install ${S}/../uEnv.txt ${DEPLOYDIR}/uEnv.txt
}
