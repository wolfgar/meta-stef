DESCRIPTION = "Transmission is a cross-platform BitTorrent client that is: easy, lean, native and powerful"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7ee657ac1dce0e7353033fc06c8087d2"

inherit autotools 

SRC_URI = "http://download.transmissionbt.com/files/transmission-2.82.tar.xz"
SRC_URI[md5sum] = "a5ef870c0410b12d10449c2d36fa4661"
SRC_URI[sha256sum] = "3996651087df67a85f1e1b4a92b1b518ddefdd84c654b8df6fbccb0b91f03522"

EXTRA_OECONF = "--enable-lightweight"

do_configure() {
        ./autogen.sh --noconfigure
        oe_runconf
}

