DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://qml/webbrowser/webbrowser.qml;endline=40;md5=a78c797054f097540ddb57fc9212183d"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

inherit qmake5

SRC_URI = "git://github.com/linux4sam/qml-browser.git;protocol=https"
PV = "1.7+git${SRCPV}"
SRCREV = "0626a3e087940bca6ced55ceee0df0074c0e9fee"

S = "${WORKDIR}/git"

inherit pkgconfig

FILES_${PN}-dbg = " \
  /opt/browser/bin/.debug \
  /opt/browser/bin/.debug/browser \
  /usr/* \
"

FILES_${PN} = " \
  /opt/browser/bin/browser \
  /opt/browser/resources/* \
  /opt/browser/qml/* \
  /opt/browser/opt/* \
  /opt/ApplicationL* \
"

do_install() {
	make INSTALL_ROOT=${D} install
	cd ${B}/opt/
	    for file in $(find browser ApplicationLauncher -type f); do
        if [ -x ${file} ]; then
            PERM="755"
        else
            PERM="644"
        fi
        echo install -m ${PERM} -D ${file} ${D}/opt/${file}
        install -m ${PERM} -D ${file} ${D}/opt/${file}
    done
}
