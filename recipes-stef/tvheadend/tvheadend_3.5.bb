DESCRIPTION = "Tvheadend is a TV streaming server and digital video recorder"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9eef91148a9b14ec7f9df333daebc746"

inherit autotools 
#lib_package pkgconfig

SRC_URI = "git://github.com/tvheadend/tvheadend.git "
SRCREV = "a1efa161f199d6cb72dd11e65baef29b34ac4ddc"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/${BPN}"
