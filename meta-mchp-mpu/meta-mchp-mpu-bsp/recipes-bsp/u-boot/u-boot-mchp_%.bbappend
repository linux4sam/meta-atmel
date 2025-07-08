FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://envs/"

inherit mchp-compat-machines
