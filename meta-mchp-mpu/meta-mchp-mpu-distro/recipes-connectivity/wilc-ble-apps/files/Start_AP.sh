#!/bin/sh
echo "---------------------------------------------------"
echo " #     #                                           "
echo " #  #  # ###### #       ####   ####  #    # ###### "
echo " #  #  # #      #      #    # #    # ##  ## #      "
echo " #  #  # #####  #      #      #    # # ## # #####  "
echo " #  #  # #      #      #      #    # #    # #      "
echo " #  #  # #      #      #    # #    # #    # #      "
echo "  ## ##  ###### ######  ####   ####  #    # ###### "
echo "---------------------------------------------------"
echo "    #    ######     ######                         "
echo "   # #   #     #    #     # ###### #    #  ####    "
echo "  #   #  #     #    #     # #      ##  ## #    #   "
echo " #     # ######     #     # #####  # ## # #    #   "
echo " ####### #          #     # #      #    # #    #   "
echo " #     # #          #     # #      #    # #    #   "
echo " #     # #          ######  ###### #    #  ####    "
echo "---------------------------------------------------"

#check wlan0 interface
check_wlan_interface() {
    if ifconfig | grep -q "wlan0" ; then
        echo "Wireless LAN interface is UP!"
    else
        echo "Wireless LAN interface has FAILED"
        echo "Reloading the wilc-sdio module"
        modprobe -r wilc-sdio
        modprobe wilc-sdio
        if lsmod | grep -q "wilc_sdio";  then
            echo "WILC-SDIO module inserted successfully"
        else
            echo "WILC-SDIO module insert failed"
            exit 1
        fi
    fi
}

# Requesting user choice for AP mode
echo "Please select AP mode:"
echo "1) Open AP"
echo "2) WPA-secured AP"
echo "Enter your choice (1/2): "
read -r ap_choice

if [ "$ap_choice" -ne 1 ] && [ "$ap_choice" -ne 2 ]; then
    echo "Invalid choice. Exiting."
    exit 2
fi

if lsmod | grep -q "wilc_sdio" ; then
    echo "1.############## WILC-SDIO module is available ##############"
else
    echo "1. Inserting the wilc-sdio module"
    modprobe wilc-sdio
    if lsmod | grep -q "wilc_sdio";  then
        echo "WILC-SDIO module insterted successfully"
    else
        echo "WILC-SDIO module insert failed"
        exit 3
    fi
fi

echo "2.############## Bringing up the wlan0 interface ##############"
check_wlan_interface

echo "3.############# Stopping wpa_supplicant service if any ####"
systemctl stop wpa_supplicant.service

keactrl stop
sleep 2

echo "4.############# Loading network configuration  #######"
cp /lib/systemd/network/80-wifi-softap.network.example /etc/systemd/network/wlan0.network
networkctl reload

echo "5.############## Starting the Host AP deamon ##############"
case $ap_choice in
    1)
        if systemctl is-active hostapd@wpa --quiet; then
            systemctl stop hostapd@wpa
        fi
        sleep 2
        check_wlan_interface
        sleep 4
        echo "Starting Open AP..."
        systemctl start hostapd@open.service
        AP_NAME="microchip-SoftAP"
        echo "This is an open network - no password"
        ;;
    2)
        if systemctl is-active hostapd@open --quiet; then
            systemctl stop hostapd@open
        fi
        sleep 2
        check_wlan_interface
        sleep 4
        echo "Starting WPA-secured AP..."
        systemctl start hostapd@wpa.service
        AP_NAME="microchip-WpaAP"
        if grep -q "wpa_passphrase" /etc/network/wilc_hostapd_wpa.conf; then
            AP_PSK=$(sed -n 's/wpa_passphrase=//p' /etc/network/wilc_hostapd_wpa.conf)
            echo "Secured network with password: $AP_PSK"
        fi
        ;;
esac

if pgrep "hostapd" > /dev/null; then
    echo "hostapd process has started successfully"
else
    echo "hostapd has failed to start"
    exit 4
fi

echo "6.############## Starting kea DHCP service ##############"
keactrl start

echo "Use a Phone/Laptop and connect to the '$AP_NAME' WiFi AP using '$AP_PSK'"
echo "---------------------------------------------------"
