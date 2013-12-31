DESCRIPTION = "Free portable AirPlay server implementation"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7fff59c88f17faa814f26f26b06a7100"

PR = "r0"
inherit autotools pkgconfig

SRC_URI = "git://github.com/juhovh/shairplay.git"
SRCREV="c8920724b694ee2b35dcb104f0bf169eb8a858d9"
S = "${WORKDIR}/git"


FILES_${PN} += "${libdir}/*.so"
