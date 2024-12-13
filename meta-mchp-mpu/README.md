# Microchip MPU layer

## Description
This layer hosts the recipes to build images for the widely supported boards of
Microchip based on ARM cores.

## Supported machines

| MPU          | SD Card                   | NAND/SPI Flash     | eMMC                  |
|--------------|---------------------------|--------------------|-----------------------|
| **SAMA5D2**  | sama5d2-icp-sd            | N/A                | N/A                   |
|              | sama5d2-ptc-ek-sd         | sama5d2-ptc-ek     | N/A                   |
|              | sama5d2-xplained-sd       | sama5d2-xplained   | sama5d2-xplained-emmc |
| **SAMA5D27** | sama5d27-som1-ek-sd       | N/A                | N/A                   |
|              | sama5d27-som1-ek-optee-sd | N/A                | N/A                   |
|              | sama5d27-wlsom1-ek-sd     | N/A                | N/A                   |
| **SAMA5D29** | sama5d29-curiosity-sd     | N/A                | N/A                   |
| **SAMA5D3**  | sama5d3-xplained-sd       | sama5d3-xplained   | N/A                   |
| **SAMA5D4**  | sama5d4-xplained-sd       | sama5d4-xplained   | N/A                   |
| **SAMA7D65** | sama7d65-curiosity-sd     | sama7d65-curiosity | N/A                   |
| **SAMA7G5**  | sama7g5ek-sd              | sama7g5ek-ospi     | sama7g5ek-emmc        |
|              | sama7g5ek-optee-sd        | N/A                | N/A                   |
| **SAM9X60**  | sam9x60-curiosity-sd      | sam9x60-curiosity  | N/A                   |
|              | sam9x60ek-sd              | sam9x60ek          | N/A                   |
| **SAM9X75**  | sam9x75-curiosity-sd      | sam9x75-curiosity  | N/A                   |
|              | sam9x75eb-sd              | sam9x75eb          | N/A                   |

For more info: https://www.linux4microchip.com/

## Layer dependencies

This layer depends on meta-mchp-common.
