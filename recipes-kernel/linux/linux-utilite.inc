DESCRIPTION = "Linux kernel for Utilite"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
DEPENDS += "lzop-native"
require recipes-kernel/linux/linux-imx.inc

SCMVERSION ?= "y"

# SRC_URI for wandboard kernel
SRC_URI = "git://github.com/wolfgar/utilite.git \
           file://defconfig \
           file://10_remove-printk.patch \
"

