FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR = "${INC_PR}.1"
# SRC_URI for wandboard kernel
SRC_URI = "git://github.com/wolfgar/linux.git \
           file://defconfig \
"
DEPENDS += "lzop-native"
LOCALVERSION = "-4.1.0-wandboard"

# Wandboard branch - based on 4.1.0 from Freescale git
SRCREV = "c0bc6d705fa3b88f8a0587ef47a079cc5d1ef271"

