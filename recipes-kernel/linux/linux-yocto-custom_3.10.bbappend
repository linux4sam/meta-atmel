KBRANCH = "linux-3.10-at91"
SRCREV = "68f2c28207fbc081f7be75fc01aca4827aa4a9f1"
PV = "${LINUX_VERSION}+${SRCPV}"

PR = "r5"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/${MACHINE}:"

SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH};nocheckout=1"
SRC_URI += "file://defconfig"
SRC_URI_append_sama5d3xek += " file://sama5d3xek.its \
			file://sama5d3xek_pda4.its \
			file://sama5d3xek_pda7.its"

do_deploy_append() {
	if [ ${UBOOT_FIT_IMAGE} = "xyes" ]; then
		DTB_PATH="${B}/arch/${ARCH}/boot/dts/"
		if [ ! -e "${DTB_PATH}" ]; then
			DTB_PATH="${B}/arch/${ARCH}/boot/"
		fi
		cp ${WORKDIR}/${MACHINE}*.its ${DTB_PATH}
		cd ${DTB_PATH}
		mkimage -f ${MACHINE}.its ${MACHINE}.itb
		install -m 0644 ${MACHINE}.itb ${DEPLOYDIR}/${MACHINE}.itb
		cd -
	fi
}

COMPATIBLE_MACHINE = "(sama5d3xek|sama5d3_xplained|at91sam9x5ek|at91sam9rlek)"
