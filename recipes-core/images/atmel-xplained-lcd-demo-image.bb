DESCRIPTION = "An image for SAMA5D3 Xplained with screen."
LICENSE = "MIT"
PR = "r1"

require atmel-demo-image.inc

IMAGE_FEATURES += "splash"

IMAGE_INSTALL += "\
    packagegroup-base-3g \
    packagegroup-base-usbhost \
    fb-test \
    tslib \
    tslib-conf \
    tslib-tests \
    tslib-calibrate \
    "

module_autoload_atmel_usba_udc = "atmel_usba_udc"
module_autoload_g_serial = "g_serial"


sama5d3_xplained_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # autoload needed modules
    cd etc
    echo "atmel_usba_udc" >> modules
    echo "g_serial" >> modules

    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "sama5d3_xplained_rootfs_postprocess; "
