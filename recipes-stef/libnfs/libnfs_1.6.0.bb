DESCRIPTION = "LIBNFS is a client library for accessing NFS shares over a network."

LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a8375400e512ca525d061f32fb28b83a"

PR = "r0"

SRC_URI = "git://github.com/sahlberg/libnfs.git;protocol=https;tag=a60caa0945786222d3722f250c247a760e0e4e36"
S = "${WORKDIR}/git"


inherit autotools lib_package pkgconfig


