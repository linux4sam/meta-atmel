require at91bootstrap.inc

SRCREV = "1e8fd41ce7149f7d2063a3b3bcf2c69e77b97732"
SRC_URI = " \
	git://github.com/linux4sam/at91bootstrap.git;protocol=https \
        file://bfa42af7a2c21bada264214d2dd209edc64eb041.patch \
        file://8af6ead234d318af463f6cfdf542bb6d31e73426.patch"

PR = "r1"

PV = "3.6.2+git${SRCPV}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
