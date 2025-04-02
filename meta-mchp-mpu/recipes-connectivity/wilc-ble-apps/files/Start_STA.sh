#!/bin/sh
echo "---------------------------------------------------"
echo "  #####  #######    #            "
echo " #     #    #      # #           "
echo " #          #     #   #          "
echo "  #####     #    #     #         "
echo "       #    #    #######         "
echo " #     #    #    #     #         "
echo "  #####     #    #     #         "
echo "---------------------------------------------------"
echo " ######  ####### #     # ####### "
echo " #     # #       ##   ## #     # "
echo " #     # #       # # # # #     # "
echo " #     # #####   #  #  # #     # "
echo " #     # #       #     # #     # "
echo " #     # #       #     # #     # "
echo " ######  ####### #     # ####### "
echo "---------------------------------------------------"
echo "---------------------------------------------------"

if lsmod | grep -q "wilc_sdio" ; then
    echo "1.############## WILC-SDIO module is available ##############"
else
    echo "1.############## Inserting the wilc-sdio module ##############"
    modprobe wilc-sdio
    if lsmod | grep -q "wilc_sdio";  then
        echo "WILC-SDIO module insterted successfully"
    else
        echo "WILC-SDIO module insert failed"
        exit 1
    fi
fi

cat << 'EOT' > /etc/wpa_supplicant.conf
ctrl_interface=/var/run/wpa_supplicant
ctrl_interface_group=0
update_config=1

network={
    key_mgmt=NONE
}
EOT

if grep -q "ssid" /etc/wpa_supplicant.conf; then
    echo "Connecting to router:-"
    sed -n "/ssid/p" /etc/wpa_supplicant.conf
    sleep 2
else
    echo "Input the SSID of the router/AP"
    read -r newSsid
    echo "New SSID ""$newSsid"
    sed -i "s/{.*/& \n\tssid=\"$newSsid\"/gI" /etc/wpa_supplicant.conf
    echo "Input the passphrase(if non-secured, press Carriage Return(Enter)"
    read -r passPhrase
    if [ "$passPhrase" = "" ]; then
        echo "Connecting to Non-Secured AP"
        sed -i "s/\bkey_mgmt\b.*/key_mgmt=NONE/gI" /etc/wpa_supplicant.conf
    else
        echo "New Passphrase ""$passPhrase"
        sed -i "s/ssid.*/& \n\tpsk=\"$passPhrase\"/gI" /etc/wpa_supplicant.conf
        sed -i "/key_mgmt/d" /etc/wpa_supplicant.conf
    fi
fi

echo "2.########### Stopping kea DHCP service if running ###########"
if pgrep -f "kea-dhcp" > /dev/null; then
    keactrl stop
fi

echo "3.########### Stopping hostapd if running any ###########"
if systemctl is-active hostapd@open --quiet; then
    systemctl stop hostapd@open
fi

if systemctl is-active hostapd@wpa --quiet; then
    systemctl stop hostapd@wpa
fi

sleep 2
echo "4.############# Loading network configuration  #######"
cp /lib/systemd/network/80-wifi-station.network.example /etc/systemd/network/wlan0.network
networkctl reload

echo "5.############## Bringing up wlan0 interface ##############"
if ifconfig | grep -q "wlan0" ; then
    echo "Wireless LAN interface is UP!"
else
    echo "Wireless LAN interface has FAILED"
    echo "2. Reloading the wilc-sdio module"
    modprobe -r wilc-sdio
    modprobe wilc-sdio
    if lsmod | grep -q "wilc_sdio";  then
        echo "WILC-SDIO module insterted successfully"
    else
        echo "WILC-SDIO module insert failed"
        exit 2
    fi
fi

sleep 4
echo "6.############## Starting WPA Supplicant  ##################"
systemctl restart wpa_supplicant.service

echo "7.############## Restart systemd-networkd service ##########"
systemctl restart systemd-networkd.service
