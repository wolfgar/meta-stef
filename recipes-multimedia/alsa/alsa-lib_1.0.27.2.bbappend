FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://imx-hdmi-soc.conf \
            file://imx-spdif.conf \
           " 

do_install_append () {
  install -d ${D}/usr/share/alsa/cards
  install -m 0644 ${WORKDIR}/imx-hdmi-soc.conf  ${D}/usr/share/alsa/cards/
  install -m 0644 ${WORKDIR}/imx-spdif.conf ${D}/usr/share/alsa/cards/
}

