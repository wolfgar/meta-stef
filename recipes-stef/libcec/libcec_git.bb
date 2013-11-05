DESCRIPTION = "libCEC allows you in combination with the right hardware to control your device with your TV remote control. Utilising your existing HDMI cabling"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=5e8e16396992369f73f3d28875f846da"

PR = "r0"
inherit autotools pkgconfig

SRC_URI = "git://github.com/wolfgar/libcec.git "
SRCREV = "90b994705ee2492afa00f914e0a070a0f0929f21"

EXTRA_OECONF="--enable-imx6"

S = "${WORKDIR}/git"


# cec-client and xbmc may need the .so present to work :(
FILES_${PN} += "${libdir}/*.so"

