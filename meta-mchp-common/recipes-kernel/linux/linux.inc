DESCRIPTION = "Linux kernel for Microchip SoCs"
SUMMARY = "Linux kernel for Microchip SoCs"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"

inherit kernel-yocto kernel

KCONFIG_MODE="--alldefconfig"

PV = "${LINUX_VERSION}+git${SRCPV}"
KERNEL_VERSION_SANITY_SKIP="1"

S = "${WORKDIR}/git"
