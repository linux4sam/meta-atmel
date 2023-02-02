FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-Revert-Initialize-temporary-buffers-in-general_compo.patch"
