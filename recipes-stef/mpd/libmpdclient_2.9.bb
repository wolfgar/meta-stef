DESCRIPTION = "Music Player Daemon library"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"
HOMEPAGE ="http://www.musicpd.org"
DEPENDS = "glib-2.0"

SRC_URI = "http://www.musicpd.org/download/libmpdclient/2/libmpdclient-2.9.tar.xz"
SRC_URI[md5sum] = "4b101a36e5c0cf967dc063391260ddbf"

EXTRA_OECONF = "--disable-documentation"

inherit autotools lib_package pkgconfig

FILES_${PN} += "usr/share/vala"
