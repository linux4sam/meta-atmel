require applicationlauncher.inc

SRC_URI[md5sum] = "0d4a646f93df9b394e9a5b0f3c241ed2"
SRC_URI[sha256sum] = "781818ea6ba6e9c90caa7edddff51366e79ec4970ade44160569b49df7fa35ab"

SRC_URI += " file://fs-overlay/opt/ApplicationLauncher/demo.config"

SRC_URI_append_sama5d4 += " file://applicationlauncher_videoplayer.patch"

do_install_append() {
	install -Dm 0664 ${WORKDIR}/fs-overlay/opt/ApplicationLauncher/demo.config \
		${D}/opt/ApplicationLauncher/demo.config
}
