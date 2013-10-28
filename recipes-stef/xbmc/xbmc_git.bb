DESCRIPTION = "software media player and entertainment hub"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://copying.txt;md5=4cea88e622381d1ad6e43f07c47513b5"
DEPENDS = "boost libass mysql5 mpeg2dec libmad libmodplug tiff yajl libtinyxml taglib libcdio jasper libmicrohttpd libssh samba rtmpdump libbluray libnfs samba swig-native"
RRECOMMENDS_${PN} = "lirc"

PR = "r2"

SRC_URI = "git://github.com/wolfgar/xbmc.git;protocol=https;tag=613e68f57bca9188be147465bcd7ff62e87e708b"

S = "${WORKDIR}/git"


inherit autotools lib_package pkgconfig gettext python-dir

EXTRA_OECONF="ac_cv_path_JAVA_EXE=/usr/bin/java \
--prefix=/imx6/xbmc --disable-x11 --disable-sdl --disable-xrandr --disable-gl --disable-vdpau --disable-vaapi --disable-openmax --enable-neon --enable-gles --enable-udev --enable-codec=imxvpu --disable-debug"


do_configure() {
  export PYTHON_EXTRA_LDFLAGS=""
  export PYTHON_EXTRA_LIBS="-lz"
  export PYTHON_VERSION="${PYTHON_BASEVERSION}"
  export PYTHON_NOVERSIONCHECK="no-check"
  export PYTHON_CPPFLAGS="-I/${STAGING_INCDIR}/${PYTHON_DIR}"
  export PYTHON_LDFLAGS="-L${STAGING_LIBDIR} -lpython${PYTHON_BASEVERSION}"

  #We will use the host java during build because there is no native recipe for full openjdk and jamvm is not able to build xbmc
  export JAVA="/usr/bin/java"

  sh bootstrap
  # oe_runconf
  # Call manually configure instead of oe_runconf because of specific prefix /imx6/xbmc...
  ${S}/configure  --build=${BUILD_SYS} \
                  --host=${HOST_SYS} \
                  --target=${TARGET_SYS} \
                  ${@append_libtool_sysroot(d)} \
                  ${EXTRA_OECONF}
}

# XBMC plugins requires python modules and dynamically loaded libraries
RRECOMMENDS_${PN} = " python-stringold \
                      python-mime \
                      python-logging \
                      python-crypt \
                      python-netclient \
                      python-threading \
                      python-elementtree \
                      python-xml \
                      python-dbus \
                      python-html \
                      python-netserver \
                      python-zlib \
                      python-sqlite3 \
                      python-pydoc \
                      python-textutils \
                      python-shell \
                      python-image \
                      python-robotparser \
                      python-compression \ 
                      python-audio \
                      python-email \
                      eglibc-gconv-cp1252 \
                      libcurl \
                      libnfs \
                      rtmpdump \
                      libbluray \ 
                      upower \
                      libmad \
                    "

FILES_${PN} += "/imx6 /usr/share/icons/hicolor"
FILES_${PN}-dbg += " \
                    /imx6/xbmc/lib/xbmc/system/players/paplayer/.debug/ \
                    /imx6/xbmc/lib/xbmc/system/players/dvdplayer/.debug/ \
                    /imx6/xbmc/lib/xbmc/system/.debug/ \
                    /imx6/xbmc/lib/xbmc/addons/library.xbmc.gui/.debug/ \
                    /imx6/xbmc/lib/xbmc/addons/library.xbmc.addon/.debug/ \
                    /imx6/xbmc/lib/xbmc/addons/visualization.glspectrum/.debug/ \
                    /imx6/xbmc/lib/xbmc/addons/library.xbmc.pvr/.debug/ \
                    /imx6/xbmc/lib/xbmc/addons/visualization.waveform/.debug/ \
                    /imx6/xbmc/lib/xbmc/.debug/ \
                   "

