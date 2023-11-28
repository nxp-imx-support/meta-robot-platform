#
# Copyright Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The i.MX Aibot2 navigation ros2 package"
AUTHOR = "Xiaodong Zhang <xiaodong.zhang@nxp.com>"
HOMEPAGE = "https://www.nxp.com"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "imx_aibot2"
ROS_BPN = "imx_aibot2_navigation"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-filters \
    nav-msgs \
    ${PYTHON_PN}-numpy-native \
    rclcpp \
    rcutils \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros1', 'catkin-native', '', d)} \
    ${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros2', 'ament-cmake-native', '', d)} \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    message-filters \
    nav-msgs \
    rclcpp \
    rcutils \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-filters \
    nav-msgs \
    rclcpp \
    rcutils \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
    robot-state-publisher \
    nav2-bringup \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS} imx-aibot2-description"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = " file://imx-aibot2-navigation.tar.gz"

S = "${WORKDIR}/git" 

ROS_BUILD_TYPE = "${@bb.utils.contains('ROS_DISTRO_TYPE','ros1','catkin','ament_cmake',d)}"

inherit ros_${ROS_BUILD_TYPE}
