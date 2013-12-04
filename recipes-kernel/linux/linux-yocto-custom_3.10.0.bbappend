FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:${THISDIR}/files:"
COMPATIBLE_MACHINE_sama5d3xek = "sama5d3xek"
COMPATIBLE_MACHINE_at91sam9x5ek = "at91sam9x5ek"
RREPLACES_${PN} = "kernel-image (< 3.10)"
RCONFLICTS_${PN} = "kernel-image (< 3.10)"
SRC_URI_append_at91sam9x5ek += "file://${MACHINE}/${KBRANCH}/UBI_config.cfg \
    file://${MACHINE}/${KBRANCH}/0001-AT91-rtc-Enable-RTC-in-device-tree.patch \ 
    file://${MACHINE}/${KBRANCH}/0002-AT91-usart-Add-USART3-to-AT91SAM9x5-device-tree.patch \ 
    file://${MACHINE}/${KBRANCH}/0001-tty-atmel_serial-prepare-clk-before-calling-enable.patch \ 
    file://${MACHINE}/${KBRANCH}/0002-drivers-tty-serial-don-t-use-devm_pinctrl_get_select.patch \ 
    file://${MACHINE}/${KBRANCH}/0003-serial-remove-unnecessary-platform_set_drvdata.patch \ 
    file://${MACHINE}/${KBRANCH}/0004-serial-at91-correct-definition-from-DMA-to-PDC.patch \ 
    file://${MACHINE}/${KBRANCH}/0005-serial-at91-use-function-pointer-to-choose-pdc-or-pi.patch \ 
    file://${MACHINE}/${KBRANCH}/0006-serial-at91-add-tx-dma-support.patch \ 
    file://${MACHINE}/${KBRANCH}/0007-serial-at91-add-rx-dma-support.patch \ 
    file://${MACHINE}/${KBRANCH}/0008-serial-at91-support-run-time-switch-transfer-mode.patch \ 
    file://${MACHINE}/${KBRANCH}/0009-serial-at91-distinguish-usart-and-uart.patch \ 
    file://${MACHINE}/${KBRANCH}/0010-serial-at91-make-UART-support-dma-and-pdc-transfers.patch \ 
    file://${MACHINE}/${KBRANCH}/0011-serial-use-dev_get_platdata.patch \ 
    file://${MACHINE}/${KBRANCH}/0012-tty-serial-at91-fix-uart-usart-selection-for-older-p.patch \ 
    file://${MACHINE}/${KBRANCH}/0013-tty-serial-at91-add-a-fallback-option-to-determine-u.patch \ 
    file://${MACHINE}/${KBRANCH}/0014-serial-unify-serial-bindings-into-a-single-dir.patch \ 
    "
    
# Increment the recipe revision
PRINC := "${@int(PRINC) + 3}"

