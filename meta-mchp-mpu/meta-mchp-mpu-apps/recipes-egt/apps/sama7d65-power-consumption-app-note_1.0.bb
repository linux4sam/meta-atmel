DESCRIPTION = "Demo script and media files for the sama7d65 series power consumption application note"
LICENSE = "CLOSED"

PR = "r1"

SRC_URI = "git://github.com/linux4sam/sama7d65_power_consumption_app_note.git;protocol=https;branch=main"
SRCREV = "ca634503c718dbb70717befe94f4cb33ce5e36f9"

S = "${WORKDIR}/git"

# The demo script requires egt_video_perf, shipped by libegt.
RDEPENDS:${PN} += "bash libegt"

# GStreamer elements used by the script's pipeline.
RDEPENDS:${PN} += "gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-base-alsa \
    gstreamer1.0-plugins-base-app \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-playback \
    gstreamer1.0-plugins-base-videoconvertscale \
    gstreamer1.0-plugins-base-volume \
    gstreamer1.0-plugins-good-isomp4 \
    ${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', 'gstreamer1.0-libav', '', d)} \
"

inherit siteinfo

FILES:${PN} += "${datadir}/app_note/sama7d65_power_consumption"

do_install() {
    install -d "${D}${bindir}"
    install -m 0755 "${S}/sama7d65_power_consumption_app_note.sh" "${D}${bindir}/sama7d65_power_consumption_app_note.sh"

    install -d "${D}${datadir}/app_note/sama7d65_power_consumption"
    install -m 0644 "${S}"/*.mp4 "${D}${datadir}/app_note/sama7d65_power_consumption/"
}

# Only useful alongside the EGT stack, which libegt restricts to little-endian.
python __anonymous () {
    endianness = d.getVar('SITEINFO_ENDIANNESS')
    if endianness == 'be':
        raise bb.parse.SkipRecipe('Requires little-endian target.')
}

