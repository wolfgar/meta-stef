# Copyright (C) 2013 Freescale Semiconductor

DESCRIPTION = "bootloader for udoo"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

PV = "v2013.10"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=6bc50ecab884fce80cd3ef3da8852b08"

# revision of 3.10.9-1.0.0 alpha branch
SRC_URI = "git://github.com/UDOOboard/U-Boot_Unico-2013.git \
           file://udoo-env.patch"
SRCREV = "b48999bc21243676a80f94ff1d2cd78418aca013"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(udoo)"


# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="-L${STAGING_BASE_LIBDIR_NATIVE} -L${STAGING_LIBDIR_NATIVE}" \
                 HOSTSTRIP=true'

