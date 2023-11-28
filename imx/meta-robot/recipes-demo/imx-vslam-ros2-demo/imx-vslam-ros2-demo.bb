#
# Copyright Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The i.MX vSLAM ros2 demo package"
AUTHOR = "Xiaodong Zhang <xiaodong.zhang@nxp.com>"
HOMEPAGE = "https://www.nxp.com"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "imx_vslam_ros2_demo"
ROS_BPN = "imx_vslam_ros2_demo"

ROS_BUILD_DEPENDS = " \
    eigen3-cmake-module-native \
    ${PYTHON_PN}-numpy-native \
    rclcpp \
    sensor-msgs \
    nav-msgs \
    std-srvs \
    cv-bridge \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
    pcl-ros \
    pcl-conversions \
"

ROS_BUILDTOOL_DEPENDS = " \
    ${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros1', 'catkin-native', '', d)} \
    ${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros2', 'ament-cmake-native', '', d)} \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    nav-msgs \
    std-srvs \
    cv-bridge \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
    pcl-ros \
    pcl-conversions \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    nav-msgs \
    std-srvs \
    cv-bridge \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
    pcl-ros \
    pcl-conversions \
    realsense2-camera \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "dbow3 libg2o sophus imx-hc-slam ${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = " file://imx-vslam-ros2-demo.tar.gz"

S = "${WORKDIR}/git" 

ROS_BUILD_TYPE = "${@bb.utils.contains('ROS_DISTRO_TYPE','ros1','catkin','ament_cmake',d)}"

inherit ros_${ROS_BUILD_TYPE} pkgconfig
