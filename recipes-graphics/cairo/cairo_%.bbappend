FILESEXTRAPATHS:prepend:sam9x60 := "${THISDIR}/${PN}:"

SRC_URI:append:sam9x60 = "\
	file://0001-cairo-path-fixed-fix-possible-buffer-overflow.patch \
	file://0002-wip-gfx2d-backend-fill-tested-and-working.patch \
	file://0003-use-a-spans-compositor-for-the-gfx2d.patch \
	file://0004-gfx2d-call-m2d_close-when-all-the-surfaces-are-destr.patch \
"

PACKAGECONFIG:append:sam9x60 = " gfx2d"
PACKAGECONFIG[gfx2d] = "--enable-gfx2d,,libm2d"

