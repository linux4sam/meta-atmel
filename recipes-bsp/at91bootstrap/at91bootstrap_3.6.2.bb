require at91bootstrap.inc

SRC_URI = " \
	https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
	file://bfa42af7a2c21bada264214d2dd209edc64eb041.patch \
	file://8af6ead234d318af463f6cfdf542bb6d31e73426.patch"

SRC_URI[tarball.md5sum] = "ec31a962b61a9d70f1afa30acfc8548a"
SRC_URI[tarball.sha256sum] = "3c6d72e0297f034dfcede600f384404ab8bfe9c411f1fac023eb63062418baca"

PACKAGE_ARCH = "${MACHINE_ARCH}"
