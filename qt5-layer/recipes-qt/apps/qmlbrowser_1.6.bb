DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://qml/webbrowser/webbrowser.qml;endline=40;md5=a78c797054f097540ddb57fc9212183d"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/qml-browser/archive/master.tar.gz;downloadfilename=qml-browser-master.tar.gz"

SRC_URI[md5sum] = "899d34ceed7797360fe122253fd6d12d"
SRC_URI[sha256sum] = "cd6b3cee307ef2154e188ade2013b5e33bd1107faa508cd40aa7bff20fd61d54"

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
