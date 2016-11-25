FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://atmel-color-format-force.patch"

# No egl on SAM9 or SAMA5
QT_CONFIG_FLAGS_append_at91sam9 = "${@base_contains('DISTRO_FEATURES', 'x11', \
                            ' -no-eglfs', ' -no-opengl -linuxfb -no-eglfs', d)}"
QT_CONFIG_FLAGS_append_sama5 = "${@base_contains('DISTRO_FEATURES', 'x11', \
                            ' -no-eglfs', ' -no-opengl -linuxfb -no-eglfs', d)}"

# qtwebkit will fail later in the build if icu is not enabled. As Poky does not
# enable it, do it here. This should be removed when the reverse dependency is
# added.
PACKAGECONFIG_append_at91sam9 = " icu"
PACKAGECONFIG_append_sama5 = " icu"
