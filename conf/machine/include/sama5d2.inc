# Atmel SAMA5D2 defaults
require sama5.inc

SOC_FAMILY = "sama5:sama5d2"

DEFAULTTUNE = "cortexa5thf-neon"

# used by sysvinit_2
SERIAL_CONSOLES ?= "57600;ttyS0"
