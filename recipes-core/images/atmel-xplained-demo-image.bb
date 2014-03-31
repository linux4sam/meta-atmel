DESCRIPTION = "An image for network and communication."
LICENSE = "MIT"
PR = "r1"

require atmel-demo-image.inc

IMAGE_INSTALL += "\
    packagegroup-base-3g \
    packagegroup-base-usbhost \
    "

sama5d3_xplained_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # autoload needed modules
    cd etc
    echo "atmel_usba_udc" >> modules
    echo "g_serial" >> modules

    cd $curdir
}
