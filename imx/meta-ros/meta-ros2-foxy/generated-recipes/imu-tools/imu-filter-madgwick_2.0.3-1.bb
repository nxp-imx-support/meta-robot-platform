# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Filter which fuses angular velocities, accelerations, and (optionally) magnetic readings from a generic IMU device into an orientation. Based on code by Sebastian Madgwick, http://www.x-io.co.uk/node/8#open_source_ahrs_and_imu_algorithms."
AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
ROS_AUTHOR = "Ivan Dryanovski <ivan.dryanovski@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/imu_filter_madgwick"
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=162b49cfbae9eadf37c9b89b2d2ac6be"

ROS_CN = "imu_tools"
ROS_BPN = "imu_filter_madgwick"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    nav-msgs \
    rclcpp \
    rclcpp-action \
    rclcpp-lifecycle \
    sensor-msgs \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    nav-msgs \
    rclcpp \
    rclcpp-action \
    rclcpp-lifecycle \
    sensor-msgs \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    nav-msgs \
    rclcpp \
    rclcpp-action \
    rclcpp-lifecycle \
    sensor-msgs \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/imu_tools-release/archive/release/foxy/imu_filter_madgwick/2.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/imu_filter_madgwick"
SRC_URI = "git://github.com/ros2-gbp/imu_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "37e637cc9d79cff728d530156b28bd81b8fd3024"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
