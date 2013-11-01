include recipes-core/images/core-image-base.bb

IMAGE_FEATURES += "debug-tweaks"

# SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"
SOC_EXTRA_IMAGE_FEATURES=""

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
    nfs-server \
    tools-debug \
    tools-profile \
"

IMAGE_INSTALL += " \
    dropbear \
    xbmc \
    networkmanager \
    procps \
    util-linux-mount \
    libntfs-3g \
    ntfsprogs \
    ntfs-3g \
    ntp \
    ntp-utils \
    tvheadend \
    util-linux \
    firmware-imx-vpu-imx6d \
    fsl-rc-local \
    xbmc-image-custom-rfs \
"

export IMAGE_BASENAME = "xbmc-image"

