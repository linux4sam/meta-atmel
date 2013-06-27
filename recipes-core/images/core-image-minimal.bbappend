IMAGE_INSTALL += "opkg \
    opkg-collateral \
    poky-feed-config-opkg \
    "

# Increment the recipe revision
PRINC := "${@int(PRINC) + 1}"    
