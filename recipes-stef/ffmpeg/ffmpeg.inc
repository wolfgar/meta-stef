DESCRIPTION = "FFmpeg is the leading multimedia framework, able to decode, encode, transcode, mux, demux, stream, filter"
HOMEPAGE = "http://www.ffmpeg.org/"
LICENSE = "GPLv2+ & LGPLv2.1+"

SRC_URI = "git://git.videolan.org/ffmpeg.git"
DEPENDS = " zlib libvorbis bzip2 "

INC_PR = "r1"

inherit autotools pkgconfig

LIC_FILES_CHKSUM = "file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://libpostproc/postprocess.c;beginline=8;endline=21;md5=3163771dd725805aeda961a4e05173b5 \
                    file://COPYING.LGPLv2.1;md5=bd7a443320af8c812e4c18d1b79df004 \
                    file://ffmpeg.c;beginline=7;endline=20;md5=0385751f4c95cb9267cc125532118221"

#S = "${WORKDIR}/git"

EXTRA_FFCONF_armv7a = "--cpu=cortex-a9"
EXTRA_OECONF = " \
        --arch=${TARGET_ARCH} \
        --cross-prefix=${TARGET_PREFIX} \
        --disable-stripping \
        --enable-cross-compile \
        --disable-devices --disable-doc \
        --disable-ffplay --disable-ffmpeg \
        --disable-ffprobe --disable-ffserver \
        --enable-gpl --enable-runtime-cpudetect \
        --enable-postproc --enable-pthreads \
        --enable-muxer=spdif --enable-muxer=adts \
        --enable-muxer=asf --enable-muxer=ipod \
        --enable-encoder=ac3 --enable-encoder=aac \
        --enable-encoder=wmav2 --enable-protocol=http \
        --enable-libvorbis \
        --enable-muxer=ogg \
        --enable-encoder=libvorbis \
        --enable-nonfree \
        --enable-pthreads \
        --enable-zlib \
        --enable-shared \
        --enable-pic \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --prefix=${prefix}/ \
        --target-os=linux \
        --disable-lzma \
        ${EXTRA_FFCONF} \
"

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations  -ftree-vectorize -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"


do_configure() {
  ${S}/configure ${EXTRA_OECONF}
}


FFMPEG_LIBS = "libavcodec libavdevice libavformat \
               libavutil libpostproc libswscale libavfilter libswresample"

PACKAGES += "${PN}-vhook-dbg ${PN}-vhook ffmpeg-x264-presets"

FILES_${PN} = "${bindir}"
FILES_${PN}-dev = "${includedir}/${PN}"

FILES_${PN}-vhook = "${libdir}/vhook"
FILES_${PN}-vhook-dbg += "${libdir}/vhook/.debug"

FILES_ffmpeg-x264-presets = "${datadir}/*.avpreset"

LEAD_SONAME = "libavcodec.so"

FILES_${PN}-dev = "${includedir}"

python populate_packages_prepend() {
    av_libdir = d.expand('${libdir}')
    av_pkgconfig = d.expand('${libdir}/pkgconfig')

    # Runtime package
    do_split_packages(d, av_libdir, '^lib(.*)\.so\..*',
                      output_pattern='lib%s',
                      description='libav %s library',
                      extra_depends='',
                      prepend=True,
                      allow_links=True)

    # Development packages (-dev, -staticdev)
    do_split_packages(d, av_libdir, '^lib(.*)\.so$',
                      output_pattern='lib%s-dev',
                      description='libav %s development package',
                      extra_depends='${PN}-dev',
                      prepend=True,
                      allow_links=True)
    do_split_packages(d, av_pkgconfig, '^lib(.*)\.pc$',
                      output_pattern='lib%s-dev',
                      description='libav %s development package',
                      extra_depends='${PN}-dev',
                      prepend=True)
    do_split_packages(d, av_libdir, '^lib(.*)\.a$',
                      output_pattern='lib%s-staticdev',
                      description='libav %s development package - static library',
                      extra_depends='${PN}-dev',
                      prepend=True,
                      allow_links=True)

    if d.getVar('TARGET_ARCH', True) == 'i586':
        # libav can't be build with -fPIC for 32-bit x86
        pkgs = d.getVar('PACKAGES', True).split()
        for pkg in pkgs:
            d.appendVar('INSANE_SKIP_%s' % pkg, ' textrel')
}

PACKAGES_DYNAMIC += "^lib(av(codec|device|filter|format|util)|postproc).*"

