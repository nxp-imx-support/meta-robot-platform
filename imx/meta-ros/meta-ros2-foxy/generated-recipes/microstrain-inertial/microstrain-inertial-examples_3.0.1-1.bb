# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Example listener for Parker LORD Sensing inertial device driver ros_mscl (C++)."
AUTHOR = "Rob Fisher <rob.fisher@parker.com>"
HOMEPAGE = "https://github.com/LORD-MicroStrain/microstrain_inertial"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "microstrain_inertial"
ROS_BPN = "microstrain_inertial_examples"

ROS_BUILD_DEPENDS = " \
    microstrain-inertial-msgs \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    microstrain-inertial-msgs \
    rclcpp \
    rclcpp-components \
    rclpy \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/microstrain_inertial-release/archive/release/foxy/microstrain_inertial_examples/3.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/microstrain_inertial_examples"
SRC_URI = "git://github.com/ros2-gbp/microstrain_inertial-release;${ROS_BRANCH};protocol=https"
SRCREV = "5f1eb4e9a8c2f9424019980eb12b2cb3f8ec1744"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
