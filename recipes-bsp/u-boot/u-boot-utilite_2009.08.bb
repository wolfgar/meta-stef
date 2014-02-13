# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "bootloader for imx platforms"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"

PR = "r1"

UBOOT_MAKE_TARGET = "u-boot.bin"

# Please, add the following variables to conf/local.conf
# in order to use this u-boot version
# UBOOT_SUFFIX = "bin"
# UBOOT_PADDING = "2"

S = "${WORKDIR}/git"
EXTRA_OEMAKE += 'HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile_prepend() {
        if [ "${@base_contains('DISTRO_FEATURES', 'ld-is-gold', 'ld-is-gold', '', d)}" = "ld-is-gold" ] ; then
                sed -i 's/$(CROSS_COMPILE)ld/$(CROSS_COMPILE)ld.bfd/g' config.mk
        fi
}

COMPATIBLE_MACHINE = "(utilite)"

SRC_URI = "git://git.gitorious.org/utilite/u-boot-2009-08.git"
SRCREV = "329e25c964edaa9bcd7d763382842ca347aaf504"


