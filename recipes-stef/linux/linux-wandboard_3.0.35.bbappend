FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# SRC_URI for wandboard kernel
SRC_URI = "git://github.com/wolfgar/linux.git;branch=${SRCBRANCH} \
           file://defconfig \
"
DEPENDS += "lzop-native"

SRCBRANCH = "wandboard_imx_3.0.35_4.1.0"
LOCALVERSION = "-4.1.0-wandboard"

# Wandboard branch - based on 4.1.0 from Freescale git
SRCREV = "b8d0163119ad7502e1255a7e1c62495fd6373234"

