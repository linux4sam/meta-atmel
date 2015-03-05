KBRANCH = "linux-3.10-at91"
SRCREV_machine = "${AUTOREV}"
PV = "${LINUX_VERSION}+${SRCPV}"

DEPENDS += "dtc-native"

PR = "r5"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/${MACHINE}:"

SRC_URI = "git://github.com/linux4sam/linux-at91.git;protocol=git;branch=${KBRANCH};nocheckout=1;name=machine"
SRC_URI += "file://defconfig"

SRCREV_machine_sama5d4-xplained = "46f4253693b0ee8d25214e7ca0dde52e788ffe95"
SRCREV_machine_sama5d3xek = "25ce4e2fcdffcf271e1f92788dee1340285dc251"
SRCREV_machine_sama5d3-xplained = "25ce4e2fcdffcf271e1f92788dee1340285dc251"

do_deploy_append() {
	if [ ${UBOOT_FIT_IMAGE} = "xyes" ]; then
		DTB_PATH="${B}/arch/${ARCH}/boot/dts/"
		if [ ! -e "${DTB_PATH}" ]; then
			DTB_PATH="${B}/arch/${ARCH}/boot/"
		fi

		cp ${S}/arch/${ARCH}/boot/dts/${MACHINE}*.its ${DTB_PATH}
		cd ${DTB_PATH}
		mkimage -f ${MACHINE}.its ${MACHINE}.itb
		install -m 0644 ${MACHINE}.itb ${DEPLOYDIR}/${MACHINE}.itb
		cd -
	fi
}

COMPATIBLE_MACHINE = "(sama5d4ek|sama5d4-xplained|sama5d3xek|sama5d3-xplained|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek)"
