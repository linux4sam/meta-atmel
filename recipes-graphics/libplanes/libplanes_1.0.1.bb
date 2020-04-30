DESCRIPTION = "Microchip libplanes library for sama5 lcd controller"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;endline=20;md5=b884a464579c410fd1dace93db8e97b3"

PACKAGES = "${PN}-dbg ${PN} ${PN}-python"

DEPENDS = "libdrm cairo cjson lua swig-native python3"

RDEPENDS_${PN} = "python3 udev-rules-at91"

SRC_URI = "git://github.com/linux4sam/libplanes.git;protocol=https \
           file://0001-Use-python3-by-default.patch \
          "

PV = "1.0.1+git${SRCPV}"
SRCREV = "34a107790f529a9b55abb924646ca89847679bfc"

S = "${WORKDIR}/git"

inherit pkgconfig autotools python3-dir

EXTRA_OECONF += "--enable-shared --disable-static"

PACKAGECONFIG ??= "examples"
PACKAGECONFIG[examples] = "--enable-examples,--disable-examples"

do_configure_prepend() {
	( cd ${S};
	${S}/autogen.sh; cd -)
}

INSANE_SKIP_${PN} = "dev-so"

FILES_${PN} += " \
  /opt/planes/planes-loop.sh \
  /opt/planes/planes-loop.py \
  /opt/ApplicationL* \
  ${libdir}/* \
  ${includedir}/* \
  ${bindir}/* \
  /usr/share/planes/* \
"
FILES_${PN}-python = "${libdir}/python${PYTHON_BASEVERSION}/site-packages/*"

#need to delete _planes.a to avoid QA package errors
do_install_append() {
    install -Dm 0644 ${S}/scripts/planes.png  ${D}/opt/ApplicationLauncher/applications/resources/planes.png
    install -Dm 0644 ${S}/scripts/09-planes.xml  ${D}/opt/ApplicationLauncher/applications/xml/09-planes.xml
    install -Dm 0755 ${S}/scripts/planes-loop.sh ${D}/opt/planes/planes-loop.sh
    install -Dm 0755 ${S}/scripts/planes-loop.py ${D}/opt/planes/planes-loop.py
    install -Dm 0755 ${S}/python/examples/splash.py ${D}/usr/share/planes/splash.py
    install -Dm 0755 ${S}/python/examples/example.py ${D}/usr/share/planes/example.py
    rm -f ${D}/usr/lib/python*/site-packages/planes/_planes.a
    rm -f ${D}/usr/lib/libplanes.a
}
