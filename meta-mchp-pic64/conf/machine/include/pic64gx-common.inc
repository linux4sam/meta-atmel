#@TYPE: Machine Include
#@SOC: PIC64GX
#@DESCRIPTION: Common Machine Configuration for PIC64GX

require conf/machine/include/riscv/tune-riscv.inc

MACHINE_FEATURES = "screen keyboard ext2 ext3 serial pci usbhost wifi"

#Add a sdmc feature to identify pic64 machines with sd or emmc
MACHINE_FEATURES:append = "${@' sdmmc' if '-nand' not in d.getVar('MACHINE') and '-nor' not in d.getVar('MACHINE') else ''}"
MACHINEOVERRIDES:append = "${@bb.utils.contains('MACHINE_FEATURES', 'sdmmc', ':autoresize', '', d)}"

KERNEL_CLASSES = "kernel-fitimage"
KERNEL_IMAGETYPE = "fitImage"
EXTERNAL_KERNEL_DEVICETREE = "${DEPLOY_DIR_IMAGE}/overlays"

KBUILD_DEFCONFIG ?= "mpfs_defconfig"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-mchp"
PREFERRED_VERSION_openocd-native = "riscv"
PREFERRED_VERSION_openocd = "riscv"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-mchp"
PREFERRED_PROVIDER_u-boot = "u-boot-mchp"
PREFERRED_VERSION_libgpiod = "1.6.4"

PREFERRED_VERSION_u-boot-mchp = "v2025.07%"

UBOOT_ENTRYPOINT = "0x80200000"
UBOOT_DTB_LOADADDRESS = "0x8a000000"
UBOOT_DTBO_LOADADDRESS = "0x8a080000"
UBOOT_RD_LOADADDRESS = "0x8aa00000"
UBOOT_RD_ENTRYPOINT = "0x8aa00000"

MACHINE_EXTRA_RRECOMMENDS += " kernel-modules"

IMAGE_FSTYPES += "wic wic.gz wic.bmap ext4"

## Do not update fstab file when using wic images
WIC_CREATE_EXTRA_ARGS ?= "--no-fstab-update"

IMAGE_INSTALL:append = " dt-overlay-mchp"

## wic default support
WKS_FILE_DEPENDS ?= " \
    e2fsprogs-native \
    bmaptool-native \
    u-boot-mchp \
"
