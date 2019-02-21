FILESEXTRAPATHS_prepend_sama5 := "${THISDIR}/files:"
FILESEXTRAPATHS_prepend_at91sam9 := "${THISDIR}/files:"

ATMEL_PATCHES = "file://atmel-color-format-force.patch \
            file://0001-make-QGraphicsItem-update-virtual.patch \
            file://0004-Provide-access-to-linuxfb-dri-fd-through-platform.patch \
            file://0005-Support-DRM-KMS-planes-in-linuxfb-DRM-backend.patch "

SRC_URI_append_at91sam9 = " ${ATMEL_PATCHES}"
SRC_URI_append_sama5 = " ${ATMEL_PATCHES}"

# No egl on SAM9 or SAMA5
QT_CONFIG_FLAGS_append_at91sam9 = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', \
                            ' -no-eglfs', ' -no-opengl -linuxfb -no-eglfs', d)}"
QT_CONFIG_FLAGS_append_sama5 = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', \
                            ' -no-eglfs', ' -no-opengl -linuxfb -qpa linuxfb -no-eglfs', d)}"

PACKAGECONFIG_append_at91sam9 = " kms"
PACKAGECONFIG_append_sama5 = " kms"

# kms PACKAGECONFIG depends on virtual/egl, we don't want that
# https://github.com/linux4sam/meta-atmel/commit/e943ecf879f43b7117e50c2ac4c0c0c8d6f97986
DEPENDS_remove_at91sam9 = "virtual/egl"
DEPENDS_remove_sama5 = "virtual/egl"

PACKAGECONFIG_append_at91sam9 = " xkbcommon-evdev"
PACKAGECONFIG_append_sama5 = " xkbcommon-evdev"
PACKAGECONFIG_remove_at91sam9 = " tests"
PACKAGECONFIG_remove_sama5 = " tests"

# qtwebkit will fail later in the build if icu is not enabled. As Poky does not
# enable it, do it here. This should be removed when the reverse dependency is
# added.
PACKAGECONFIG_append_at91sam9 = " icu"
PACKAGECONFIG_append_sama5 = " icu"
PACKAGECONFIG_append_sama5 = " accessibility"
PACKAGECONFIG_append_sama5 = " libinput"
