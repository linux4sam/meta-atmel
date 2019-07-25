FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#Patch for QT 5.12.4 only
SRC_URI += "${@bb.utils.contains('SRCREV', 'd73b59093ec6fed8138460adcdf3ea0a45519a3c', 'file://0001-fix-qt5.12.4-compile-issue-when-no-opengl-in-QVideoSurfa.patch', '', d)}"
