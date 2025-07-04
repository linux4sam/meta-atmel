fdt addr ${fdtcontroladdr}
fdt get value board_compatible / compatible 1
setenv fitconf conf-${board_compatible}.dtb

ubifsload ${scriptaddr} boot/fitImage
ubifsumount
ubi detach
bootm start ${scriptaddr}#${fitconf}#conf-microchip,mpfs_icicle_pmod_sf3.dtbo
bootm loados ${scriptaddr};
# Try to load a ramdisk if available inside fitImage
bootm ramdisk;
bootm prep;
run design_overlays;
bootm go;
