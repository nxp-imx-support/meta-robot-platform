DESCRIPTION = "A Robot image with more full-featured + ROS  full package + OpenCV Linux system functionality installed."

LICENSE = "MIT"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    splash \
    nfs-server \
    ssh-server-dropbear \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-imx-ml \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
"
IMAGE_INSTALL += " clblast libeigen opencv gmssl-bin ethercat"

IMAGE_FEATURES:remove = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'x11-base', '', d)}"

CORE_IMAGE_EXTRA_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                                              'weston-xwayland weston-init weston-examples \
                                               gtk+3-demo clutter-1.0-examples xterm', '', d)}"

IMAGE_INSTALL += " \
    ${@bb.utils.contains('ROS_DISTRO', 'noetic', 'robot', '', d)} \
    ${@bb.utils.contains('ROS_DISTRO', 'foxy', 'ros-base', '', d)} \
    ${@bb.utils.contains('ROS_DISTRO', 'humble', 'ros-base', '', d)} \
"
