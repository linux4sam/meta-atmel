DEPENDS_NOX11 := "${@oe_filter_out('nativesdk-libx11', '${DEPENDS}', d)}"
DEPENDS := "${@base_contains('DISTRO_FEATURES', 'x11', '${DEPENDS}', '${DEPENDS_NOX11}', d)}"
