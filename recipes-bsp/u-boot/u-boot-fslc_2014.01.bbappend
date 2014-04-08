FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot-imx:"
FILESEXTRAPATHS_prepend_wandboard :="${THISDIR}/u-boot-imx/wandboard:"
FILESEXTRAPATHS_prepend_utilite := "${THISDIR}/u-boot-imx/utilite:"
FILESEXTRAPATHS_prepend_udoo := "${THISDIR}/u-boot-imx/udoo:"

SRC_URI_append_wandboard += "file://0001-change-wand-bootdelay.patch " 
SRC_URI += "file://env.txt "

DEPENDS = "u-boot-mkimage-native"

inherit deploy

do_install_append_mx6 () {
  uboot-mkimage -A arm -T script -C none -d ${WORKDIR}/env.txt ${WORKDIR}/bootscript-${MACHINE} 
}

do_deploy_append_mx6 () {
    install -d ${DEPLOYDIR}
    install ${WORKDIR}/bootscript-${MACHINE} \
            ${DEPLOYDIR}/bootscript-${MACHINE}
}

addtask deploy after do_install 

