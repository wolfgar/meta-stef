DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
#SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
#DEPENDS = "virtual/kernel virtual/libx11 libxau libsm libice"
DEPENDS = "virtual/kernel"
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/lirc/lirc-${PV}.tar.gz \
      file://lircd.init file://lircmd.init"
S = "${WORKDIR}/lirc-${PV}"

inherit autotools module-base update-rc.d

INITSCRIPT_NAME = "lircd"
INITSCRIPT_PARAMS = "defaults 20"

include lirc-config.inc

#EXTRA_OEMAKE = 'SUBDIRS="daemons tools"'

#do_install() {
#        oe_libinstall -so -C tools liblirc_client ${STAGING_LIBDIR}
#	install -d ${STAGING_INCDIR}/lirc/
#	install -m 0644 tools/lirc_client.h ${STAGING_INCDIR}/lirc/
#}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/lircd.init ${D}${sysconfdir}/init.d/lircd

        install -d ${D}${datadir}/lirc/
        cp -pPR ${S}/remotes ${D}${datadir}/lirc/
}



SRC_URI[md5sum] = "83e97622acc4aa38a2f0cb102f4c00ef"
SRC_URI[sha256sum] = "863b5c6e2a43f2699d3198827985ee87788a215fff42be6d2408c71d8d562a2e"
FILES_${PN} += "/run/lirc"

