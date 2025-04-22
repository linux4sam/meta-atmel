ubifsload ${scriptaddr} boot/fitImage
ubifsumount
ubi detach
bootm start ${scriptaddr}#conf-mpfs-icicle-kit.dtb#conf-mpfs_icicle_pmod_sf3.dtbo
bootm loados ${scriptaddr};
# Try to load a ramdisk if available inside fitImage
bootm ramdisk;
bootm prep;
run design_overlays;
bootm go;
