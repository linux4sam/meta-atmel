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
| `MACHINE=mpfs-icicle-kit-nand`      | MPFS-ICICLE-KIT-ES, MPFS-ICICLE-KIT| PolarFire SoC Icicle Kit with Winbond W25N01GV NAND flash memory boot |
| `MACHINE=mpfs-icicle-kit-nor`       | MPFS-ICICLE-KIT-ES, MPFS-ICICLE-KIT| PolarFire SoC Icicle Kit with Micron MT25QL256 NOR flash memory boot  |
| `MACHINE=mpfs-disco-kit`            | MPFS-DISCO-KIT                     | PolarFire SoC Discovery Kit                                           |
| `MACHINE=mpfs-video-kit`            | MPFS250-VIDEO-KIT                  | PolarFire SoC Video Kit                                               |
| `MACHINE=beaglev-fire`              | BEAGLEV-FIRE                       | BeagleBoard.org BeagleV-Fire single-board computer (SBC)              |
| `MACHINE=m100pfsevp`                | M100PFSEVP                         | Aries M100PFSEVP PolarFire SoC-FPGA Evaluation Platform               |

> Note: All Icicle Kit images (except for the authenticated boot variants) include a mechanism to automatically detect whether the board is an engineering sample or a production kit, and will boot with the appropriate device tree accordingly. For authenticated boot machines, however, there are separate Yocto machines: use mpfs-icicle-kit-es-auth for engineering samples and mpfs-icicle-kit-prod-auth for production devices.

The complete User Guides for each development platform, containing board and boot instructions, are available for the following supported platforms:

- [ICICLE-KIT-ES](https://mi-v-ecosystem.github.io/redirects/icicle-kit-sw-developer-guide_icicle-kit-sw-developer-guide) (Icicle Kit Engineering Sample)
- [MPFS-VIDEO-KIT](https://mi-v-ecosystem.github.io/redirects/boards-mpfs-sev-kit-sev-kit-user-guide) (PolarFire SoC Video Kit)
- [MPFS-DISCO-KIT](https://mi-v-ecosystem.github.io/redirects/boards-mpfs-discovery-kit-user-guide) (PolarFire SoC Discovery Kit)
- [BEAGLEV-FIRE](https://docs.beagle.cc/boards/beaglev/fire/02-quick-start.html) (BeagleV-Fire)

## Layer dependencies

This layer depends on:

URI: git://git.openembedded.org/openembedded-core
layers: meta

URI: git://git.yoctoproject.org/meta-openembedded
layers: meta-oe, meta-python, meta-multimedia, meta-networking

URI: git://github.com/linux4microchip/meta-mchp.git
layers: meta-mchp-common
