DESCRIPTION = "libssh is a mulitplatform C library \
implementing the SSHv2 and SSHv1 protocol for client \
and server implementations."

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=388a4fb1dea8ceae0be78ba9b01fc139"
DEPENDS = "zlib openssl"

PR = "r0"

SRC_URI = "\
  http://www.libssh.org/files/0.5/libssh-${PV}.tar.gz \
"
inherit cmake

# Add build directory.
OECMAKE_BUILDPATH = "${WORKDIR}/build"
EXTRA_OEMAKE = "-C ${OECMAKE_BUILDPATH}"
OECMAKE_SOURCEPATH = "${WORKDIR}/libssh-${PV}"

SRC_URI[md5sum] = "9ad01838d3b89d98e900e0f6260a88cc"
SRC_URI[sha256sum] = "ed42a6c94c74bafed580caeaf40af83ec409aaa1b83010cb1e1c60b94f10daf0"

