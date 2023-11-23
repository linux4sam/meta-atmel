FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-keactrl.in-create-var-lib-kea-and-var-run-kea-folder.patch"
