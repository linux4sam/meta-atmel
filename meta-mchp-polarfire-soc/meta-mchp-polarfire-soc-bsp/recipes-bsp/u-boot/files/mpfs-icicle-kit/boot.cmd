setenv fdt_high 0xffffffffffffffff
setenv initrd_high 0xffffffffffffffff

fdt addr ${fdtcontroladdr}
fdt get value board_compatible / compatible 1
setenv fitconf conf-${board_compatible}.dtb
load mmc 0:${distro_bootpart} ${scriptaddr} fitImage
bootm start ${scriptaddr}#${fitconf}#conf-microchip,mpfs_icicle_cpu_opp.dtbo
bootm loados ${scriptaddr};
# Try to load a ramdisk if available inside fitImage
bootm ramdisk;
bootm prep;
run design_overlays;
bootm go;
