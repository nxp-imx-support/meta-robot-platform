DESCRIPTION = "A Robot image with base-featured + ROS core Linux system functionality installed."

LICENSE = "MIT"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_FEATURES += " \
    tools-profile \
    splash \
    ssh-server-dropbear \
    hwcodecs \
"
CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-imx-core-tools \
    cryptodev-module \
    cryptodev-tests \
    openssl-bin \
    gmssl-bin \
    imx-test \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-imx-ml \
"
IMAGE_INSTALL += " \ 
    ros-core \
"

IMAGE_FEATURES:remove = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'x11-base', '', d)}"
