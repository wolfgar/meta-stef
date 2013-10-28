EXTRA_OECONF = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=${DRIVER}"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"


DRIVER ?= "serial"
# fails to build at the moment, re-enable later
#DRIVER_collie = "sa1100"
DRIVER_h3600 = "sa1100"
DRIVER_simpad = "sa1100"
DRIVER_nslu2 = "nslu2"
#DEPENDS_wandboard-quad = "libirman"
DRIVER_wandboard-quad = "usb_irtoy"

# XXX Why is X disabled on all these platforms anyway?
EXTRA_OECONF_append_collie = " --without-x"
EXTRA_OECONF_append_h3600 = " --without-x"
EXTRA_OECONF_append_simpad = " --without-x"
EXTRA_OECONF_append_nslu2 = " --without-x --with-transmitter --with-soft-carrier"
EXTRA_OECONF_append_wandboard-quad = " --without-x"

