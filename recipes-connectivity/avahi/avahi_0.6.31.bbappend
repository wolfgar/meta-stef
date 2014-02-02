FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " file://avahi-daemon.conf "

do_install_append () {
install -d ${D}/etc/avahi/
install -m 0644 ${WORKDIR}/avahi-daemon.conf ${D}/etc/avahi/
}
