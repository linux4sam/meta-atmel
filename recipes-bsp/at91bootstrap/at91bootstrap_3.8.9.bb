require at91bootstrap.inc

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd)'

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
	file://Add_-fno-builtin_to_CPPFLAGS_for_gcc7.patch \
"

SRC_URI[tarball.md5sum] = "b4d5a31cce559f11a957243f437bf020"
SRC_URI[tarball.sha256sum] = "a93c0f84dc583b38b5999d0dd27623d7a57957b197f1f4d3f1b7d54b7d5ee499"
