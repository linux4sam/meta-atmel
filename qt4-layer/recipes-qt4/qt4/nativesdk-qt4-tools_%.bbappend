DEPENDS_NOX11 := "${@oe.utils.str_filter_out('nativesdk-libx11', '${DEPENDS}', d)}"
DEPENDS := "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '${DEPENDS}', '${DEPENDS_NOX11}', d)}"
