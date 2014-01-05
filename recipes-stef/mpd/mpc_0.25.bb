DESCRIPTION = "Music Player Daemon Client"
DEPENDS = "libmpdclient"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
HOMEPAGE ="http://www.musicpd.org"

PR = "r5"

SRC_URI = " \
    http://www.musicpd.org/download/mpc/0/mpc-0.25.tar.xz \
"
SRC_URI[md5sum] = "76aec8e973e3c6c131e9e9f2ad8f34c3"

EXTRA_OECONF = "--disable-documentation"

inherit autotools
