#!/bin/bash

IMAGE=$1
TTY=$2
BOARD=$3
LCD=${4:-none}

family_at91sam9g45m10ek="at91sam9m10g45ek"
mach_at91sam9g45m10ek="at91sam9m10-g45-ek"
dtb_at91sam9g45m10ek="at91sam9m10g45ek.dtb"

family_at91sam9rlek="at91sam9rlek"
mach_at91sam9rlek="at91sam9rl64-ek"
dtb_at91sam9rlek="at91sam9rlek.dtb"

family_at91sam9g15ek="at91sam9x5ek"
mach_at91sam9g15ek="at91sam9g15-ek"
dtb_at91sam9g15ek="at91sam9g15ek.dtb"

family_at91sam9g25ek="at91sam9x5ek"
mach_at91sam9g25ek="at91sam9g25-ek"
dtb_at91sam9g25ek="at91sam9g25ek.dtb"

family_at91sam9g35ek="at91sam9x5ek"
mach_at91sam9g35ek="at91sam9g35-ek"
dtb_at91sam9g35ek="at91sam9g35ek.dtb"

family_at91sam9x25ek="at91sam9x5ek"
mach_at91sam9x25ek="at91sam9x25-ek"
dtb_at91sam9x25ek="at91sam9x25ek.dtb"

family_at91sam9x35ek="at91sam9x5ek"
mach_at91sam9x35ek="at91sam9x35-ek"
dtb_at91sam9x35ek="at91sam9x35ek.dtb"

family_sama5d31ek="sama5d3xek"
mach_sama5d31ek="at91sama5d3x-ek"
dtb_sama5d31ek="sama5d31ek.dtb"
dtb_sama5d31ek_pda4="sama5d31ek_pda4.dtb"
dtb_sama5d31ek_pda7="sama5d31ek_pda7.dtb"

family_sama5d31ek_revc="sama5d3xek"
mach_sama5d31ek_revc="at91sama5d3x-ek"
dtb_sama5d31ek_revc="sama5d31ek_revc.dtb"
dtb_sama5d31ek_revc_pda4="sama5d31ek_revc_pda4.dtb"
dtb_sama5d31ek_revc_pda7="sama5d31ek_revc_pda7.dtb"

family_sama5d33ek="sama5d3xek"
mach_sama5d33ek="at91sama5d3x-ek"
dtb_sama5d33ek="sama5d33ek.dtb"
dtb_sama5d33ek_pda4="sama5d33ek_pda4.dtb"
dtb_sama5d33ek_pda7="sama5d33ek_pda7.dtb"

family_sama5d33ek_revc="sama5d3xek"
mach_sama5d33ek_revc="at91sama5d3x-ek"
dtb_sama5d33ek_revc="sama5d33ek_revc.dtb"
dtb_sama5d33ek_revc_pda4="sama5d33ek_revc_pda4.dtb"
dtb_sama5d33ek_revc_pda7="sama5d33ek_revc_pda7.dtb"

family_sama5d34ek="sama5d3xek"
mach_sama5d34ek="at91sama5d3x-ek"
dtb_sama5d34ek="sama5d34ek.dtb"
dtb_sama5d34ek_pda4="sama5d34ek_pda4.dtb"
dtb_sama5d34ek_pda7="sama5d34ek_pda7.dtb"

family_sama5d34ek_revc="sama5d3xek"
mach_sama5d34ek_revc="at91sama5d3x-ek"
dtb_sama5d34ek_revc="sama5d34ek_revc.dtb"
dtb_sama5d34ek_revc_pda4="sama5d34ek_revc_pda4.dtb"
dtb_sama5d34ek_revc_pda7="sama5d34ek_revc_pda7.dtb"

family_sama5d35ek="sama5d3xek"
mach_sama5d35ek="at91sama5d3x-ek"
dtb_sama5d35ek="sama5d35ek.dtb"

family_sama5d35ek_revc="sama5d3xek"
mach_sama5d35ek_revc="at91sama5d3x-ek"
dtb_sama5d35ek_revc="sama5d35ek_revc.dtb"

family_sama5d36ek="sama5d3xek"
mach_sama5d36ek="at91sama5d3x-ek"
dtb_sama5d36ek="sama5d36ek.dtb"
dtb_sama5d36ek_pda4="sama5d36ek_pda4.dtb"
dtb_sama5d36ek_pda7="sama5d36ek_pda7.dtb"

family_sama5d36ek_revc="sama5d3xek"
mach_sama5d36ek_revc="at91sama5d3x-ek"
dtb_sama5d36ek_revc="sama5d36ek_revc.dtb"
dtb_sama5d36ek_revc_pda4="sama5d36ek_revc_pda4.dtb"
dtb_sama5d36ek_revc_pda7="sama5d36ek_revc_pda7.dtb"

family_sama5d3_xplained="sama5d3_xplained"
mach_sama5d3_xplained="at91sama5d3x-xplained"
dtb_sama5d3_xplained="at91-sama5d3_xplained.dtb"
dtb_sama5d3_xplained_pda4="at91-sama5d3_xplained_pda4.dtb"
dtb_sama5d3_xplained_pda7="at91-sama5d3_xplained_pda7.dtb"

family_sama5d4ek="sama5d4ek"
mach_sama5d4ek="at91sama5d4x-ek"
dtb_sama5d4ek="at91-sama5d4ek.dtb"

family_sama5d4_xplained="sama5d4_xplained"
mach_sama5d4_xplained="at91sama5d4x-ek"
dtb_sama5d4_xplained="at91-sama5d4_xplained.dtb"
dtb_sama5d4_xplained_pda4="at91-sama5d4_xplained_pda4.dtb"

usage() {
	cat << EOF
Usage:
  $0 <image_name> <interface> <board> [lcd]

Available boards:
  at91sam9g45m10ek
  at91sam9rlek
  at91sam9g15ek
  at91sam9g25ek
  at91sam9x25ek
  at91sam9g35ek
  at91sam9x35ek
  sama5d31ek
  sama5d33ek
  sama5d34ek
  sama5d35ek
  sama5d36ek
  sama5d31ek_revc (Until rev. C)
  sama5d33ek_revc (Until rev. C)
  sama5d34ek_revc (Until rev. C)
  sama5d35ek_revc (Until rev. C)
  sama5d36ek_revc (Until rev. C)
  sama5d3_xplained
  sama5d4ek
  sama5d4_xplained

Example:
  $0 atmel-qt5-demo-image /dev/ttyACM0 at91sam9g45m10ek
EOF
}

F="family_$BOARD"
M="mach_$BOARD"
D="dtb_$BOARD"

if [[ $# < 3 || -z ${!F} ]]; then
	usage
	exit 1
fi

case $LCD in
	pda4)
		video_mode="video=Unknown-1:480x272-16"
		D="${D}_${LCD}"
		;;
	pda7)
		video_mode="video=Unknown-1:800x480-16"
		D="${D}_${LCD}"
		;;
	*)
		video_mode="video=Unknown-1:800x480-16"
		;;
esac

if [[ -z ${!D} ]]; then
	echo "unknown board and LCD combination"
	exit 1
fi

if [[ -z $(which bitbake) ]]; then
	echo "bitbake not in path please setup the environment"
	exit 1
fi

eval $(MACHINE=${!F/_/-} bitbake -e $IMAGE | grep -E "(^DEPLOY_DIR_IMAGE|^IMAGE_LINK_NAME|^STAGING_BINDIR_NATIVE)")

SAMBA=$(which sam-ba)
if [[ -z $SAMBA ]]; then
	SAMBA=${STAGING_BINDIR_NATIVE}/sam-ba_cdc_linux/sam-ba
fi

if [[ ! -f $SAMBA ]]; then
	echo "Couldn't find sam-ba. Add it to your path or bitbake sam-ba-native"
	exit 1
fi

echo "Executing: O=${DEPLOY_DIR_IMAGE}/ $SAMBA $TTY ${!M} $(dirname $0)/nandflash.tcl -- ${!F} zImage-${!D} $rootfs $video_mode"
export O=${DEPLOY_DIR_IMAGE}/
$SAMBA $TTY ${!M} $(dirname $0)/nandflash.tcl -- ${!F} zImage-${!D} ${IMAGE_LINK_NAME}.ubi $video_mode
