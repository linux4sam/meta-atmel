require at91bootstrap.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/linux4sam/at91bootstrap.git;protocol=git \
          "
S = "${WORKDIR}/git"

PV = "3.8+git${SRCPV}"

LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=a2a70db58191379e2550cbed95449fbd"

# If a recipe sets SRCREV to ${AUTOREV}, bitbake tries
# a git ls-remote. This breaks when a mirror is built
# and BB_NO_NETWORK is set.
# To work-around the issue, sets the revision for the git
# version to a fix commit.
def version_git(d):
    version = d.getVar("PREFERRED_VERSION_%s" % d.getVar('PN'))
    if version is not None and "git" in version:
        return d.getVar("AUTOREV")
    else:
        return "7a4704642d28784713a030be68eaa19074c18317"

SRCREV ?= '${@version_git(d)}'

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd)'
