FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://atmel-color-format-force.patch \
            file://0001-make-QGraphicsItem-update-virtual.patch \
            file://0003-Add-support-for-specifying-DRM-dumb-buffer-pixel-for.patch \
            file://0004-Provide-access-to-linuxfb-dri-fd-through-platform.patch \
            file://0005-Support-DRM-KMS-planes-in-linuxfb-DRM-backend.patch "

# No egl on SAM9 or SAMA5
QT_CONFIG_FLAGS_append_at91sam9 = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', \
                            ' -no-eglfs', ' -no-opengl -linuxfb -no-eglfs', d)}"
QT_CONFIG_FLAGS_append_sama5 = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', \
                            ' -no-eglfs', ' -no-opengl -linuxfb -qpa linuxfb -no-eglfs', d)}"

PACKAGECONFIG[kms] = "-kms,-no-kms,drm libdrm"
PACKAGECONFIG += "kms"

PACKAGECONFIG_append = " xkbcommon-evdev"
PACKAGECONFIG_remove = " tests"

# qtwebkit will fail later in the build if icu is not enabled. As Poky does not
# enable it, do it here. This should be removed when the reverse dependency is
# added.
PACKAGECONFIG_append_at91sam9 = " icu"
PACKAGECONFIG_append_sama5 = " icu"
PACKAGECONFIG_append_sama5 = " accessibility"
PACKAGECONFIG_append_sama5 = " libinput"
