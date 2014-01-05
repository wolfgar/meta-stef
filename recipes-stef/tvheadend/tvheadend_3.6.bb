DESCRIPTION = "Tvheadend is a TV streaming server and digital video recorder"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9eef91148a9b14ec7f9df333daebc746"
DEPENDS = "libdvbcsa"

inherit autotools 
#lib_package pkgconfig

SRC_URI = "git://github.com/tvheadend/tvheadend.git "
SRCREV = "819627ecc7db69537134ff01e946992a9ff631ca"

S = "${WORKDIR}/git"

EXTRA_OECONF="--enable-dvbcsa"

FILES_${PN} += "${datadir}/${BPN}"
