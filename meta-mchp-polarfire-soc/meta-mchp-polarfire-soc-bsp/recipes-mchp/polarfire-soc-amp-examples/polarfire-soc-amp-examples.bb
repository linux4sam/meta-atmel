SUMMARY = "Polarfire SoC AMP example applications"
DESCRIPTION = "Example FreeRTOS application to run in AMP build \
along with a Linux context"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE.md;md5=736a28e202059f476d2e3e1c80e5b009"

DEPENDS = "makedepend-native"

inherit deploy

PV = "1.0+git${SRCPV}"
SRCREV="v2024.02"
SRC_URI = "git://github.com/polarfire-soc/polarfire-soc-amp-examples.git;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

EXT_CFLAGS += "--sysroot=${STAGING_DIR_TARGET}"
EXT_CFLAGS += "-DMPFS_HAL_FIRST_HART=4 -DMPFS_HAL_LAST_HART=4"
EXT_CFLAGS += "-fdebug-prefix-map=${TMPDIR}=${TARGET_DBGSRC_DIR}"

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "REMOTE=1 REMOTEPROC=1 CROSS_COMPILE=${TARGET_PREFIX} EXT_CFLAGS='${EXT_CFLAGS}'"

do_install() {
    install -Dm 0644 ${S}/mpfs-rpmsg-${AMP_DEMO}/Remote-Default/mpfs-rpmsg-remote.elf ${D}/usr/lib/firmware/rproc-miv-rproc-fw
}

do_compile() {
   oe_runmake -C ${S}/mpfs-rpmsg-${AMP_DEMO}
}

do_deploy() {
    install -m 755 ${S}/mpfs-rpmsg-${AMP_DEMO}/Remote-Default/mpfs-rpmsg-remote.elf ${DEPLOYDIR}/amp-application.elf
}

addtask deploy after do_install

COMPATIBLE_MACHINE = "(mpfs-icicle-kit-es-amp)"

FILES:${PN} += "/usr/lib/firmware/rproc-miv-rproc-fw"
