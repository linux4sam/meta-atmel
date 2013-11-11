MAINTAINER = "Ole Wolf <ole@naturloven.dk>"
HOMEPAGE = "http://www.sixxs.net"
SUMMARY = "SixXS Automatic IPv6 Connectivity Client Utility"
DESCRIPTION = "This client automatically gives one IPv6 connectivity without having to manually configure interfaces etc.  One does need a SixXS account and at least a tunnel. These can be freely & gratis requested from the SixXS website.  For more information about SixXS check http://www.sixxs.net"
PROVIDES = "aiccu"

SRC_URI = " \
	http://www.sixxs.net/archive/sixxs/aiccu/unix/aiccu_current.tar.gz \
	file://04_kfreebsd.patch \
	file://06_syslog_openlog.patch \
	file://07_allow_tunnels.patch \
	file://09_binutils_gold.patch \
"

SRC_URI[sha256sum] = "2260f426c13471169ccff8cb4a3908dc5f79fda18ddb6a55363e7824e6c4c760"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://doc/LICENSE;md5=52f14a594e56aac39483fbae4c99235c"
S = "${WORKDIR}/aiccu"

DEPENDS_${PN} += "awk eglibc gnutls"
#RDEPENDS_${PN} += "glibc gnutls"
RDEPENDS_${PN} += "eglibc gnutls"
RRECOMMENDS_${PN} = "ntp"

FILES_${PN} = " \
	${sysconfdir}/aiccu.conf \
	${sysconfdir}/init.d/aiccu \
	${sbindir}/aiccu \
"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}" DESTDIR=${D}'

do_compile () {
	RPM_OPT_FLAGS="0" oe_runmake -C unix-console
}

do_install () {
	DESTDIR=${D} oe_runmake install

	install -m 0755 -d ${D}${sysconfdir}
	install -m 0600 ${S}/doc/aiccu.conf ${D}${sysconfdir}
	install -m 0755 -d ${D}${sysconfdir}/init.d
	install -m 0755 ${S}/doc/aiccu.init.debian ${D}${sysconfdir}/init.d/aiccu
}
