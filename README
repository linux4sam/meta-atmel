This layer provides support for Microchip microprocessors (aka AT91)
====================================================================

For more information about the Microchip MPU product line see:
http://www.microchip.com/design-centers/32-bit-mpus
Linux & Open Source on Microchip microprocessors:
http://www.linux4sam.org


Supported SoCs / MACHINE names
==============================
Note that most of the machine names below, have a SD Card variant that can be
built by adding an "-sd" suffix to the machine name.
- SAMA5D2 product family / sama5d2-xplained, sama5d2-xplained-emmc, sama5d27-som1-ek-sd, sama5d27-som1-ek-optee-sd, sama5d2-ptc-ek, sama5d2-icp, sama5d27-wlsom1-ek-sd
- SAMA5D4 product family / sama5d4ek, sama5d4-xplained
- SAMA5D3 product family / sama5d3xek, sama5d3-xplained
- AT91SAM9x5 product family (AT91SAM9G15, AT91SAM9G25, AT91SAM9X25, AT91SAM9G35 and AT91SAM9X35) / at91sam9x5ek
- AT91SAM9RL / at91sam9rlek
- AT91SAM9G45 / at91sam9m10g45ek
- SAM9X60 / sam9x60ek
- SAMA7G5 / sama7g5ek-sd, sama7g5ek-emmc, sama7g5ek-ospi


Sources
=======
- meta-atmel
URI: git://github.com/linux4sam/meta-atmel.git
URI: https://github.com/linux4sam/meta-atmel.git
Branch: master


Dependencies
============
This Layer depends on :
- poky
URI: git://git.yoctoproject.org/poky
Branch: kirkstone
Tag:HEAD

- meta-openembedded
URI: git://git.openembedded.org/meta-openembedded
URI: http://cgit.openembedded.org/meta-openembedded/
Branch: kirkstone
Tag: HEAD

- meta-aws (for AWS Greengrass)
URI: git://github.com/aws/meta-aws.git
URI: https://github.com/aws/meta-aws
Branch: kirkstone
Tag:HEAD

- meta-arm (for optee components)
URI: git://git.yoctoproject.org/meta-arm
URI: https://git.yoctoproject.org/meta-arm
Branch: kirkstone
Tag:HEAD

Build procedure
===============

0/ Create a directory
mkdir my_dir
cd my_dir

1/ Clone yocto/poky git repository with the proper branch ready
git clone git://git.yoctoproject.org/poky -b kirkstone

2/ Clone meta-openembedded git repository with the proper branch ready
git clone git://git.openembedded.org/meta-openembedded -b kirkstone

3/ Clone meta-aws git repository with the proper branch ready (optional)
git clone git://github.com/aws/meta-aws -b kirkstone

4/ Clone meta-atmel layer with the proper branch ready
git clone git://github.com/linux4sam/meta-atmel.git -b kirkstone

5/ Clone meta-arm layer with the proper branch ready
git clone https://git.yoctoproject.org/meta-arm -b kirkstone

6/ Enter the poky directory to configure the build system and start the build process
cd poky
If not created yet, add a new "build-microchip" directory:
mkdir build-microchip
Else, if it's the first time you use Yocto Project templates, and if the
build-microchip directory remains from a previous use, we advise you to start
from a fresh directory. Keep your build-microchip/conf/local.conf file for
reference.

7/ Inside the .templateconf file, you will need to modify the TEMPLATECONF
variable to match the path to the meta-atmel layer "conf" directory:
export TEMPLATECONF=${TEMPLATECONF:-../meta-atmel/conf}

8/ Initialize build directory
source oe-init-build-env build-microchip

9/ To build a small image provided by Yocto Project:
[MACHINE=<machine>] bitbake core-image-minimal

Example for sama5d2-xplained-sd SD card image:
MACHINE=sama5d2-xplained-sd bitbake core-image-minimal

10/ To build the microchip image with no graphics support:
[MACHINE=<machine>] bitbake microchip-headless-image

Example for sama5d2-xplained-sd SD card image:
MACHINE=sama5d2-xplained-sd bitbake microchip-headless-image

11/ To build the microchip image with graphics support (EGT):
[MACHINE=<machine>] bitbake microchip-graphics-image

Example for sama5d2-xplained-sd SD card image:
MACHINE=sama5d2-xplained-sd bitbake microchip-graphics-image

Typical bitbake output
======================
Build Configuration:
BB_VERSION           = "2.0.0"
BUILD_SYS            = "x86_64-linux"
NATIVELSBSTRING      = "universal"
TARGET_SYS           = "arm-poky-linux-gnueabi"
MACHINE              = "sam9x60-curiosity-sd"
DISTRO               = "poky-atmel"
DISTRO_VERSION       = "4.0.5"
TUNE_FEATURES        = "arm armv5 thumb dsp"
TARGET_FPU           = "soft"
meta                 
meta-poky            
meta-yocto-bsp       = "heads/kirkstone-4.0.5:2e79b199114b25d81bfaa029ccfb17676946d20d"
meta-oe              
meta-networking      
meta-webserver
meta-python          
meta-initramfs       = "kirkstone:744a4b6eda88b9a9ca1cf0df6e18be384d9054e3"
meta-atmel           = "kirkstone:e71f4b71dba523c464cbb7aaa374b3e5e92bb674"
meta-multimedia      = "kirkstone:744a4b6eda88b9a9ca1cf0df6e18be384d9054e3"
meta-arm
meta-arm-toolchain   = "kirkstone:bafd1d013c2470bcec123ba4eb8232ab879b2660"

Contributing
============
To contribute to this layer you should submit the patches for review to:
the github pull-request facility directly or the forum. Anyway, don't forget to
Cc the maintainers.

AT91 Forum:
http://www.at91.com/discussions/

for some useful guidelines to be followed when submitting patches:
http://www.openembedded.org/wiki/How_to_submit_a_patch_to_OpenEmbedded

Maintainers:
Hari Prasath G E <Hari.PrasathGE@microchip.com>
Nicolas Ferre <nicolas.ferre@microchip.com>

When creating patches insert the [meta-atmel] tag in the subject, for example
use something like:
git format-patch -s --subject-prefix='meta-atmel][PATCH' <origin>
