require applicationlauncher.inc

SRC_URI ="git://github.com/linux4sam/application-launcher.git;protocol=https;branch=fixes-qt5.12"
SRCREV = "96f47a1c4eb6f3bffbb4bb31a04d6c0236e300b7"
PV = "1.11+git${SRCPV}"

SRC_URI += " file://fs-overlay/opt/ApplicationLauncher/demo.config \
           "
S = "${WORKDIR}/git"

SRC_URI_append_sama5d4 += " file://applicationlauncher_videoplayer.patch"

do_install_append() {
	install -Dm 0664 ${WORKDIR}/fs-overlay/opt/ApplicationLauncher/demo.config \
		${D}/opt/ApplicationLauncher/demo.config
}
