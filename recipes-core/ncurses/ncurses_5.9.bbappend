do_configure_prepend() {
	# The --enable-pc-files requires PKG_CONFIG_LIBDIR existed
	mkdir -p ${PKG_CONFIG_LIBDIR}
}
