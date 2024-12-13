# Common to all machines in mpu
MACHINE_FEATURES += " apm alsa ext2 ext3 usbhost usbgadget screen touchscreen"
MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " dt-overlay-mchp"

# Add bootloaders to the images of every machine
EXTRA_IMAGEDEPENDS += " at91bootstrap virtual/bootloader"

# Add deploy functions to the wic image dependency
do_image_wic[depends] += " u-boot-mchp:do_deploy"
do_image_wic[depends] += " dt-overlay-mchp:do_deploy"
