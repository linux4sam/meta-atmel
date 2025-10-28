FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LINUX_VERSION = "6.12.22"
KBRANCH = "linux-6.12-mchp+fpga"
SRCREV = "linux4microchip+fpga-2025.10"

SRC_URI:append:pic64gx-curiosity-kit = " file://pic64gx_v4l2.cfg"

do_assemble_fitimage[depends] = "${@'dt-overlay-mchp:do_deploy' \
                                  if "pic64gx-curiosity-kit" in d.getVar('MACHINE') \
                                  else ''}"

addtask deploy after do_install
