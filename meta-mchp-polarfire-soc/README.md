# Microchip PolarFire SoC layer

## Description

Collection of OpenEmbedded/Yocto Project layers for PolarFire SoC.

- **meta-polarfire-soc-bsp**: layer containing platform/machine configurations for PolarFire SoC evaluation boards

- **meta-polarfire-soc-community**: layer containing platform/machine configurations for Microchip's partners' evaluation kits

## Supported machines

| `MACHINE`                     | Board Name                                                                                  |
| ----------------------------- | ------------------------------------------------------------------------------------------- |
| `MACHINE=mpfs-icicle-kit-es`  | ICICLE-KIT-ES, Icicle Kit engineering samples                                                |
| `MACHINE=mpfs-icicle-kit-es-amp` | ICICLE-KIT-ES, Icicle Kit engineering samples in AMP mode                                  |
| `MACHINE=mpfs-icicle-kit-es-nand` | ICICLE-KIT-ES, Icicle Kit engineering samples with Winbond W25N01GV NAND flash memory boot |
| `MACHINE=mpfs-icicle-kit-es-nor`  | ICICLE-KIT-ES, Icicle Kit engineering samples with Micron MT25QL256 NOR flash memory boot  |
| `MACHINE=mpfs-disco-kit`      | MPFS-DISCO-KIT, PolarFire SoC Discovery Kit                                                  |
| `MACHINE=mpfs-video-kit`      | MPFS250-VIDEO-KIT, PolarFire SoC Video Kit                                                   |
| `MACHINE=beaglev-fire`        | BeagleV-Fire, BeagleBoard.org BeagleV-Fire single-board computer (SBC)                       |
| `MACHINE=m100pfsevp`          | M100PFSEVP, Aries M100PFSEVP PolarFire SoC-FPGA Evaluation Platform                          |

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
