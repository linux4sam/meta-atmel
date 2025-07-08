# Common to all machines in mpu
MACHINE_FEATURES += " apm alsa ext2 ext3 usbhost usbgadget screen touchscreen"

# Add bootloaders to the images of every machine
EXTRA_IMAGEDEPENDS += " at91bootstrap virtual/bootloader"
