DESCRIPTION = "XBMC network manager addon"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=7226e01ff2d738e2246d467214c409b9"
DEPENDS += "xbmc"

PR = "r0"
SRC_URI = "http://mirrors.xbmc.org/addons/frodo/script.linux.nm/script.linux.nm-0.1.4.zip"
SRC_URI[md5sum] = "918ffb412b571d3e0e00f1d8a7e9e4fb"
S = "${WORKDIR}/script.linux.nm/"
do_install() {
        install -d ${D}/home/root/.xbmc/addons/
        cp -axr ${S} ${D}/home/root/.xbmc/addons/
}

FILES_${PN} += "/home/root/.xbmc/addons/script.linux.nm"

