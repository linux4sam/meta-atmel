FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

KBRANCH:mpfs = "linux-6.12-mchp+fpga"
SRCREV:mpfs = "linux4microchip+fpga-2025.10"

# Define a list of machines that depend on dt-overlay-mchp:do_deploy task
DT_OVERLAY_MACHINES = "mpfs-icicle-kit \
                       mpfs-icicle-kit-amp \
                       mpfs-icicle-kit-nand \
                       mpfs-icicle-kit-nor \
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

do_deploy:append:mpfs() {

    if [ -n "${INITRAMFS_IMAGE}" ]; then

        if [ "${INITRAMFS_IMAGE_BUNDLE}" != "1" ]; then
                ln -snf fitImage-${INITRAMFS_IMAGE_NAME}-${KERNEL_FIT_NAME}${KERNEL_FIT_BIN_EXT} "$deployDir/fitImage"
        fi
    fi
}

addtask deploy after do_install
