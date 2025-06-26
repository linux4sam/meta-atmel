#!/bin/bash

export UBOOT_SIGN_KEYNAME="mpfs_fitimage_key"
export HSS_PAYLOAD_PRIVATE_KEYNAME="x509-ec-secp384r1-private"
export HSS_PAYLOAD_PUBLIC_KEYNAME="x509-ec-secp384r1-public"

main () {
	if [ "$_" = "$0" ]; then
		echo "Please initialize the OpenEmbedded build environment before running this script"
		exit 1
	fi

	if [ -n "$OUTDIR" ]; then
		echo "Using a user-defined output directory"
		validate_dir
	else
		if [ -z "$BBPATH" ]; then
			echo "Bitbake environment not initialized"
			echo "Please initialize the OpenEmbedded build environment before running this script"
			exit 1
		else
			OUTDIR="$BBPATH/../keys"
			echo "Using the default output directory"
			validate_dir
		fi
	fi
}

validate_dir () {
	if [ ! -f "$OUTDIR/$UBOOT_SIGN_KEYNAME.key" ] || [ ! -f "$OUTDIR/$HSS_PAYLOAD_PRIVATE_KEYNAME.pem" ]; then
		OUTDIR=$(readlink -f $OUTDIR)
		echo "The following keys will be deployed to $OUTDIR:"
		echo "$OUTDIR/$UBOOT_SIGN_KEYNAME.key"
		echo "$OUTDIR/$HSS_PAYLOAD_PRIVATE_KEYNAME.pem"
		echo "$OUTDIR/$HSS_PAYLOAD_PUBLIC_KEYNAME.der"

		if [ ! -d "$OUTDIR" ]; then
			mkdir -p $OUTDIR
		fi

		generate_keys
		export_env

	else
		echo "There are existing keys in $OUTDIR, new keys won't be generated."
		export_env
	fi
}

export_env () {
	echo "Exporting environment variables to BitBake"
	export UBOOT_SIGN_KEYDIR="$OUTDIR"
	export HSS_PAYLOAD_KEYDIR="$OUTDIR"
	export BB_ENV_PASSTHROUGH_ADDITIONS="${BB_ENV_PASSTHROUGH_ADDITIONS} UBOOT_SIGN_KEYDIR"
	export BB_ENV_PASSTHROUGH_ADDITIONS="${BB_ENV_PASSTHROUGH_ADDITIONS} UBOOT_SIGN_KEYNAME"
	export BB_ENV_PASSTHROUGH_ADDITIONS="${BB_ENV_PASSTHROUGH_ADDITIONS} HSS_PAYLOAD_PRIVATE_KEYNAME"
	export BB_ENV_PASSTHROUGH_ADDITIONS="${BB_ENV_PASSTHROUGH_ADDITIONS} HSS_PAYLOAD_KEYDIR"
}

generate_keys () {
	echo "Generating FIT Image Signing Keys..."
	openssl genrsa -F4 -out $OUTDIR/$UBOOT_SIGN_KEYNAME.key 4096 > /dev/null 2>&1
	openssl req -batch -new -x509 -key $OUTDIR/$UBOOT_SIGN_KEYNAME.key -out $OUTDIR/$UBOOT_SIGN_KEYNAME.crt > /dev/null 2>&1

	echo "Generating HSS Payload Signing Keys (HPSK and HPSQ)..."
	openssl ecparam -genkey -name secp384r1 -param_enc named_curve -out $OUTDIR/$HSS_PAYLOAD_PRIVATE_KEYNAME.pem > /dev/null 2>&1
	openssl ec -in $OUTDIR/$HSS_PAYLOAD_PRIVATE_KEYNAME.pem -pubout -out $OUTDIR/$HSS_PAYLOAD_PUBLIC_KEYNAME.der -outform DER > /dev/null 2>&1
}

print_usage () {
	echo ""
	echo "Usage: polarfire-soc_auth_setup.sh [-o <path>] [-h]"
	echo ""
	echo "-o Generate OpenSSL keys in the specified path"
	echo "-h print this help"
	echo ""
}

if [ $# -eq 0 ]; then
	main
fi

for arg in "$@"; do
	case $arg in
	-o)
		OUTDIR=$(readlink -f $2 2>/dev/null)
		if [ ! -z $OUTDIR ]; then
			main
		fi
		shift
		shift
		;;
	-h)
		print_usage
		shift
		;;
	*)
		;;
	esac
done

unset OUTDIR
