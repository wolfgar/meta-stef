DESCRIPTION = "libCEC allows you in combination with the right hardware to control your device with your TV remote control. Utilising your existing HDMI cabling"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e296fd6027598da75a7516ce1ae4f56a"

PR = "r2"
inherit autotools pkgconfig

SRC_URI = "git://github.com/xbmc-imx6/libcec.git "
SRCREV = "5e00ba12d63b6f9240c2b6ee914b35a7735262aa"

EXTRA_OECONF="--enable-imx6"

S = "${WORKDIR}/git"


# cec-client and xbmc may need the .so present to work
FILES_${PN} += "${libdir}/*.so"

