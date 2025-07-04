fdt addr ${fdtcontroladdr}
fdt get value board_compatible / compatible 1
setenv fitconf conf-${board_compatible}.dtb

ubifsload 0x80000000 boot/fitImage
cp 0x80000000 ${scriptaddr} ${filesize}
bootm start ${scriptaddr}#${fitconf}#conf-microchip,mpfs_icicle_flash5_click.dtbo
bootm loados ${scriptaddr};
# Try to load a ramdisk if available inside fitImage
bootm ramdisk;
bootm prep;
run design_overlays;
bootm go;
