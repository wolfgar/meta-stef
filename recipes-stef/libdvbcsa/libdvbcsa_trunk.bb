DESCRIPTION = "DVD Common Scrambling Algorithm"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

PR = "r19"

SRC_URI = "svn://svn.videolan.org/libdvbcsa;module=trunk \
           file://dvbcsa-bootstrap.patch"
SRCREV = "19"
S = "${WORKDIR}/trunk"

inherit autotools

do_configure() {
  sh bootstrap
  oe_runconf
}
