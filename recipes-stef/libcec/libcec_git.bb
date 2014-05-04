DESCRIPTION = "libCEC allows you in combination with the right hardware to control your device with your TV remote control. Utilising your existing HDMI cabling"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=5e8e16396992369f73f3d28875f846da"

PR = "r2"
inherit autotools pkgconfig

SRC_URI = "git://github.com/xbmc-imx6/libcec.git "
SRCREV = "42c3c07a79b8155635851c2eed9558b221b89047"

EXTRA_OECONF="--enable-imx6"

S = "${WORKDIR}/git"


# cec-client and xbmc may need the .so present to work :(
FILES_${PN} += "${libdir}/*.so"

