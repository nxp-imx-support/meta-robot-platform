DESCRIPTION = "A Robot image with more full-featured + ROS  SDK + OpenCV Linux system functionality installed."

LICENSE = "MIT"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-sdk \
    tools-profile \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-dropbear \
    tools-testapps \
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
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-imx-ml \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
"
IMAGE_INSTALL += " cmake git clblast libeigen opencv opencv-dev ceres libg2o dbow2 dbow3 iperf3"

IMAGE_FEATURES:remove = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'x11-base', '', d)}"

CORE_IMAGE_EXTRA_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                                              'weston-xwayland weston-init weston-examples \
                                               gtk+3-demo clutter-1.0-examples xterm', '', d)}"

IMAGE_INSTALL += " \ 
    ${@bb.utils.contains('ROS_DISTRO', 'noetic', 'packagegroup-imx-ros-sdk-noetic imx-aibot1 teb-local-planner imx-vslam-ros1-demo', '', d)} \
    ${@bb.utils.contains('ROS_DISTRO', 'foxy', 'packagegroup-imx-ros-sdk-foxy imx-vslam-ros2-demo', '', d)} \
    ${@bb.utils.contains('ROS_DISTRO', 'humble', 'packagegroup-imx-ros-sdk-humble imx-vslam-ros2-demo imx-aibot2', '', d)} \
"

IMAGE_INSTALL += " \
    packagegroup-qt6-imx \
    tzdata \
"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake \
    ${@bb.utils.contains('ROS_DISTRO', 'noetic', 'nativesdk-catkin', '', d)} \
"

                                             
