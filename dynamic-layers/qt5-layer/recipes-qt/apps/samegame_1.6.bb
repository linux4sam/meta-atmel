DESCRIPTION = "Microchip samegame QT demo"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;endline=39;md5=8f2a7549bdcd8bed89187e21d29be11f"

PACKAGES = "${PN}-dbg ${PN}"

DEPENDS = "qtbase qtdeclarative qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/samegame/archive/v${PV}.tar.gz;downloadfilename=${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "39709b52871275bf575cad21ffaf134a"
SRC_URI[sha256sum] = "1488fd156f2c69e6ef4b6d5c0ef3f16526a91769ca7bbbf433f4975c64ea8ba8"

S = "${WORKDIR}/${PN}-${PV}"

inherit pkgconfig

FILES_${PN}-dbg = " \
  /opt/samegame/.debug \
  /opt/samegame/.debug/samegame \
  /usr/* \
  /opt/samegame/samegame.pro \
  /opt/samegame/samegame.qmlproject \
  /opt/samegame/main.cpp \
  /opt/samegame/moc_qmlapplicationviewer.cpp \
"

FILES_${PN} = " \
  /opt/samegame/samegame \
  /opt/samegame/resources/samegame.sh \
  /opt/samegame/qml/* \
  /opt/ApplicationL* \
"

do_install() {
	make INSTALL_ROOT=${D} install
}
