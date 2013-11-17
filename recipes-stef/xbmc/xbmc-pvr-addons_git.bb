DESCRIPTION = "pvr addons for XBMC"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit autotools 

SRC_URI = "git://github.com/opdenkamp/xbmc-pvr-addons.git"
SRCREV = "accba457b54f0a2f85b56d3b1bab1790b6fcd656"
CACHED_CONFIGUREVARS = "ac_cv_lib_GL_main=no"
S = "${WORKDIR}/git"

EXTRA_OECONF="--prefix=/imx6/xbmc"

do_configure() {

  sh bootstrap
  # oe_runconf
  # Call manually configure instead of oe_runconf because of specific prefix /imx6/xbmc...
  ${CACHED_CONFIGUREVARS} ${S}/configure  --build=${BUILD_SYS} \
                  --host=${HOST_SYS} \
                  --target=${TARGET_SYS} \
                  ${@append_libtool_sysroot(d)} \
                  ${EXTRA_OECONF}
}



FILES_${PN} += "/imx6/xbmc/share/xbmc/addons"
FILES_${PN}-dbg += "/imx6/xbmc/lib/xbmc/addons"
