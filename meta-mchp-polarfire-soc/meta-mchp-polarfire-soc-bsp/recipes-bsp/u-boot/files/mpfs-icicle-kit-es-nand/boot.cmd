
ubifsload 0x80000000 boot/fitImage
cp 0x80000000 ${scriptaddr} ${filesize}
bootm start ${scriptaddr}#conf-mpfs-icicle-kit.dtb#conf-mpfs_icicle_flash5_click.dtbo
bootm loados ${scriptaddr};
# Try to load a ramdisk if available inside fitImage
bootm ramdisk;
bootm prep;
run design_overlays;
bootm go;
