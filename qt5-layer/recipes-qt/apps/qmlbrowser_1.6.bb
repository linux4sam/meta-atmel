DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://qml/webbrowser/webbrowser.qml;endline=40;md5=a78c797054f097540ddb57fc9212183d"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/qml-browser/archive/master.tar.gz;downloadfilename=qml-browser-master.tar.gz"

SRC_URI[md5sum] = "6842f59bbee379866a1706523592afeb"
SRC_URI[sha256sum] = "e551459f7dabba30cb476bb6c46eaad451a96f65476ef32dabbf05102cdc0b23"

S = "${WORKDIR}/qml-browser-master"

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
