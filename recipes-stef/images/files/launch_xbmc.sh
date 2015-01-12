#!/bin/sh

mkdir -p /tmp/temp
                                       
export KODI_HOME=/imx6/kodi/share/kodi
export XDG_DATA_HOME=/home/root/
export XDG_CACHE_HOME=/home/root/

/imx6/kodi/lib/kodi/kodi.bin 2> /dev/null &

