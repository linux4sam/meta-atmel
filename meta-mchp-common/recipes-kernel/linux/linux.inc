DESCRIPTION = "Linux kernel for Microchip SoCs"
SUMMARY = "Linux kernel for Microchip SoCs"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"

inherit kernel

PV = "${LINUX_VERSION}+git${SRCPV}"

S = "${WORKDIR}/git"
