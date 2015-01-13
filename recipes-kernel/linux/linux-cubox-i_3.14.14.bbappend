do_install_append () {
  rm  ${D}/lib/firmware/korg/k1212.dsp
  rmdir ${D}/lib/firmware/korg
}

