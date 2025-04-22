FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LINUX_VERSION = "6.6.75"
KBRANCH = "linux-6.6-mchp+fpga"
SRCREV = "linux4microchip+fpga-2025.03"

# Define a list of machines that depend on dt-overlay-mchp:do_deploy task
DT_OVERLAY_MACHINES = "mpfs-icicle-kit-es \
                       mpfs-icicle-kit-es-amp \
                       mpfs-icicle-kit-es-nand \
                       mpfs-icicle-kit-es-nor \
                       mpfs-video-kit"

SRC_URI:append:mpfs-icicle-kit-all = " \
    file://qspi_flash.cfg \
    file://rpi_sense_hat.cfg \
    file://mcp23s08_spi.cfg \
"

SRC_URI:append:mpfs-video-kit = " \
    file://mpfs_crypto.cfg \
"

do_assemble_fitimage[depends] = "${@'dt-overlay-mchp:do_deploy' if d.getVar('MACHINE') in d.getVar('DT_OVERLAY_MACHINES').split() else ''}"
