SUMMARY = "OSCam: Open Source Conditional Access Module"
HOMEPAGE = "http://www.streamboard.tv/oscam/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "libusb1 openssl"

SRC_URI = "git://github.com/gfto/oscam.git"
SRCREV="438564d01f5aa6d0790679b3f026687297cf21ff"
PV = "1.20+${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DDEFAULT_CS_CONFDIR=${sysconfdir} -DCMAKE_BUILD_TYPE=Debug"
