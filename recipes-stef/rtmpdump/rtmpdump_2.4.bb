DESCRIPTION = "Toolkit for RTMP streams."

DEPENDS = "zlib openssl"
HOMEPAGE = "http://rtmpdump.mplayerhq.hu/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

#KSV Patch is from http://stream-recorder.com/forum/customized-rtmpdump-binaries-patch-file-t16103.html
SRC_URI = "git://git.ffmpeg.org/rtmpdump;protocol=git;tag=8e3064207fa7535baad07fd06b65630ec8b31a08 \
	   file://KSV_20130611.patch;striplevel=0 \
	   file://makefile_path.patch"

S = "${WORKDIR}/git/"
PR = "r0"

EXTRA_OEMAKE = "'CC=${CC}'"

do_install () {
	mkdir -p ${D}/${libdir}
	oe_runmake install DESTDIR=${D} BINDIR=${D}/${bindir} SBINDIR=${D}/${sbindir} MANDIR=${D}/${mandir} \
            INCDIR=${D}/${includedir}/librtmp LIBDIR=${D}/${libdir}
}
