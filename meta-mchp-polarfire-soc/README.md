# Microchip PolarFire SoC layer

## Description

Collection of OpenEmbedded/Yocto Project layers for PolarFire SoC.

- **meta-mchp-polarfire-soc-bsp**: layer containing platform/machine configurations for PolarFire SoC evaluation boards

- **meta-mchp-polarfire-soc-community**: layer containing platform/machine configurations for Microchip's partners' evaluation kits

## Supported machines

| `MACHINE`                           | Board Name                         | Description                                                           |
| ------------------------------------| -----------------------------------|-----------------------------------------------------------------------|
| `MACHINE=mpfs-icicle-kit`           | MPFS-ICICLE-KIT-ES, MPFS-ICICLE-KIT| PolarFire SoC Icicle Kit                                              |
| `MACHINE=mpfs-icicle-kit-amp`       | MPFS-ICICLE-KIT-ES, MPFS-ICICLE-KIT| PolarFire SoC Icicle Kit in Asymmetric Multiprocessing (AMP) mode     |
| `MACHINE=mpfs-icicle-kit-es-auth`   | MPFS-ICICLE-KIT-ES                 | PolarFire SoC Icicle Kit engineering sample with authenticated boot   |
| `MACHINE=mpfs-icicle-kit-prod-auth` | MPFS-ICICLE-KIT                    | PolarFire SoC Icicle Kit with authenticated boot                      |
| `MACHINE=mpfs-icicle-kit-nand`      | MPFS-ICICLE-KIT-ES, MPFS-ICICLE-KIT| PolarFire SoC Icicle Kit with Winbond W25N01GV NAND flash memory boot |
| `MACHINE=mpfs-icicle-kit-nor`       | MPFS-ICICLE-KIT-ES, MPFS-ICICLE-KIT| PolarFire SoC Icicle Kit with Micron MT25QL256 NOR flash memory boot  |
| `MACHINE=mpfs-disco-kit`            | MPFS-DISCO-KIT                     | PolarFire SoC Discovery Kit                                           |
| `MACHINE=mpfs-video-kit`            | MPFS250-VIDEO-KIT                  | PolarFire SoC Video Kit                                               |
| `MACHINE=beaglev-fire`              | BEAGLEV-FIRE                       | BeagleBoard.org BeagleV-Fire single-board computer (SBC)              |
| `MACHINE=m100pfsevp`                | M100PFSEVP                         | Aries M100PFSEVP PolarFire SoC-FPGA Evaluation Platform               |

> Note: All Icicle Kit images (except for the authenticated boot variants) include a mechanism to automatically detect whether the board is an engineering sample or a production kit, and will boot with the appropriate device tree accordingly. For authenticated boot machines, however, there are separate Yocto machines: use mpfs-icicle-kit-es-auth for engineering samples and mpfs-icicle-kit-prod-auth for production devices.

The `mpfs-icicle-kit-es-auth` and `mpfs-icicle-kit-prod-auth` machines can be used to build an image that demonstrates a simple approach for booting an authenticated Linux kernel. Please see the [Linux Boot Authentication](https://mi-v-ecosystem.github.io/redirects/linux-boot-authentication) documentation for further details on how to build an authentication scheme implementing a chain of trust.

The `mpfs-icicle-kit-amp` machine can be used to build the Icicle Kit engineering sample with AMP support. Please see
the [Asymmetric Multiprocessing (AMP)](https://mi-v-ecosystem.github.io/redirects/asymmetric-multiprocessing_amp) documentation for further details.

The complete User Guides for each development platform, containing board and boot instructions, are available for the following supported platforms:

- [ICICLE-KIT-ES](https://mi-v-ecosystem.github.io/redirects/icicle-kit-sw-developer-guide_icicle-kit-sw-developer-guide) (Icicle Kit Engineering Sample)
- [MPFS-VIDEO-KIT](https://mi-v-ecosystem.github.io/redirects/boards-mpfs-sev-kit-sev-kit-user-guide) (PolarFire SoC Video Kit)
- [MPFS-DISCO-KIT](https://mi-v-ecosystem.github.io/redirects/boards-mpfs-discovery-kit-user-guide) (PolarFire SoC Discovery Kit)
- [BEAGLEV-FIRE](https://docs.beagle.cc/boards/beaglev/fire/02-quick-start.html) (BeagleV-Fire)

## Image Targets

The table below describes some custom Microchip image targets that can be used to run various demos, as well as recommended
standard OpenEmbedded image targets. For additional standard OpenEmbedded images, please refer to the
[OpenEmbedded documentation](https://docs.yoctoproject.org/dev/ref-manual/images.html#images).

| `MACHINE`                     | Description                                                                                    |
| ----------------------------- | ---------------------------------------------------------------------------------------------- |
| `core-image-minimal`          | A small image just capable of allowing a device to boot                                        |
| `core-image-minimal-mtdutils` | A core-image-minimal image that has support for MTD Utilities                                  |
| `mchp-base-image`             | A Microchip base image with standard Linux utilities, as well as some Microchip apps and examples             |
| `mchp-base-image-sdk`         | A Microchip base image with additional support for software development, including toolchains and debug tools |

The `core-image-minimal-mtdutils` target generates a Linux image in `.mtdimg` format, which is needed for programming to the officially supported QSPI flash memories when using the `mpfs-icicle-kit-nand` and `mpfs-icicle-kit-nor` machines.

> [!IMPORTANT]
Login with root account, there is no password set.

## Build Instructions

Please see the meta-mchp-common [README](https://github.com/linux4microchip/meta-mchp/blob/scarthgap/meta-mchp-common/README.md) section for detailed steps on how to setup and start a build for any of the supported devices.

## Deploy Instructions

### Copying a Disk Image to a SD card or eMMC Storage Device

1. **Recommended Tool:** Use `bmaptool` to write the disk image to your storage device. It’s faster than traditional tools like `dd` or `cp`.

2. **Find the Image:**  
   The disk image (a `.wic` file) is in `yocto-dev/build/tmp-glibc/deploy/images/<MACHINE>/`.  
   Example:  
   `yocto-dev/build/tmp-glibc/deploy/images/mpfs-icicle-kit/mchp-base-image-mpfs-icicle-kit.wic`

3. **Prepare the Target Storage Device**  
   Either the eMMC storage or an SD card can be programmed as follows:

   - **To program the eMMC via USB:**
      - Reset the board by either power cycling or using the `RESET` command in the HSS.
      - When prompted to `Press a key to enter CLI`, press any key to enter the HSS CLI.
      - Enter `usbdmsc` into the HSS.
      - If the device is properly connected to your host computer, you should see data being read.

   - **To program an SD card:**
      - Insert an SD card or microSD card into the host computer using an SD card reader.

4. **Flash the Image:**

     ```sh
     sudo bmaptool copy tmp-glibc/deploy/images/icicle-kit-es/mchp-base-image-mpfs-icicle-kit.rootfs.wic /dev/sdX
     ```

   - **Important:**
     Double-check the device name (`/dev/sdX`) using `dmesg`, `lsblk`, or GNOME Disks to avoid overwriting your system disk.

### Copying the Disk Image to External QSPI Flash Memory

1. **Preparation:**
   Follow the instructions for your specific QSPI flash memory (Winbond or Micron) in the [booting from QSPI](https://mi-v-ecosystem.github.io/redirects/booting-from-qspi_booting-from-qspi) documentation.

2. **Connect to Board:**
   - Connect to UART0 (J11) with settings: 115200 baud, 8 data bits, 1 stop bit, no parity, no flow control.
   - Power on the board and stop automatic boot by pressing a key.
   - In the HSS console, type "qspi", then "usbdmsc" to expose QSPI as a block device.
   - Connect the board to your PC using J16 (next to the SD card slot).

3. **Write the Image:**

     ```sh
     sudo dd if=<IMAGE_PATH> of=/dev/sdX
     ```

   - For Winbond NAND:
     `<IMAGE_PATH>` = `tmp-glibc/deploy/images/icicle-kit-es-nand/core-image-minimal-mtdutils-mpfs-icicle-kit-nand.nand.mtdimg`

   - For Micron NOR:
     `<IMAGE_PATH>` = `tmp-glibc/deploy/images/icicle-kit-es-nor/core-image-minimal-mtdutils-mpfs-icicle-kit-nor.nor.mtdimg`

   - **Important:**
     Double-check the device name (`/dev/sdX`) using `dmesg`, `lsblk`, or GNOME Disks to avoid overwriting your system disk.

4. **After Writing:**
   - In the HSS serial console, press `CTRL+C` to return to the console.
   - Wait for the transfer to finish (progress bar will show).
   - To boot Linux, type `boot` in the HSS console.

## Layer dependencies

Please see the respective READMEs in the layer subdirectories.
