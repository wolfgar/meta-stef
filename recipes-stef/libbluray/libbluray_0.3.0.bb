DESCRIPTION = "Library to access Blu-Ray disks"
SECTION = "libs/multimedia"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=435ed639f84d4585d93824e7da3d85da"

PR = "r0"

SRC_URI = "git://git.videolan.org/${PN}.git;protocol=git;tag=44d9d11301cdec999f1262511df46a0a5eacee50"

S = "${WORKDIR}/git"


inherit autotools lib_package pkgconfig


