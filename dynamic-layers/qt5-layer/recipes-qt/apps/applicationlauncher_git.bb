require applicationlauncher.inc

SRC_URI ="git://github.com/linux4sam/application-launcher.git;protocol=https"
SRCREV = "38fe8b5476a331b8ddc4aff6872afcbaff8942e2"
PV = "1.11+git${SRCPV}"

SRC_URI += " file://fs-overlay/opt/ApplicationLauncher/demo.config \
             file://0001-fix-page-flipping.patch \
             file://qml-Fix-scaling-on-screens-with-resolution-higher-th.patch \
           "
S = "${WORKDIR}/git"

SRC_URI_append_sama5d4 += " file://applicationlauncher_videoplayer.patch"

do_install_append() {
	install -Dm 0664 ${WORKDIR}/fs-overlay/opt/ApplicationLauncher/demo.config \
		${D}/opt/ApplicationLauncher/demo.config
}
