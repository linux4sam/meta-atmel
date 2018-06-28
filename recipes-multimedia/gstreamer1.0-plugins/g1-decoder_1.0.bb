DESCRIPTION = "G1 Hantro decoder"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://software/source/inc/basetype.h;endline=36;md5=e3202b62900668ae783c037af34f1ff5"

PR = "r1"

inherit autotools pkgconfig gettext

SRC_URI = "git://github.com/linux4sam/g1_decoder.git;branch=master;protocol=http"

SRCREV = "cb81273566b7c1609ce27bbf38af8042946472f7"

S = "${WORKDIR}/git/"

do_configure_prepend() {
    (cd ${S};
    chmod +x ${S}/autogen.sh;
    ${S}/autogen.sh; cd -)
}

COMPATIBLE_MACHINE = "sama5d4"
