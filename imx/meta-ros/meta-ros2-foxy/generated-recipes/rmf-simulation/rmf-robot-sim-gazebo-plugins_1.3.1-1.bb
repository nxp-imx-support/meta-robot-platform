# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "ROS 2 Gazebo plugins for TeleportIngestors, TeleportDispensers and Readonly Objects"
AUTHOR = "Luca Della Vedova <luca@openrobotics.org>"
ROS_AUTHOR = "Luca Della Vedova"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "rmf_simulation"
ROS_BPN = "rmf_robot_sim_gazebo_plugins"

ROS_BUILD_DEPENDS = " \
    gazebo-ros \
    gazebo-rosdev \
    geometry-msgs \
    libeigen \
    rclcpp \
    rmf-building-map-msgs \
    rmf-fleet-msgs \
    rmf-robot-sim-common \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    gazebo-ros \
    gazebo-rosdev \
    geometry-msgs \
    libeigen \
    rclcpp \
    rmf-building-map-msgs \
    rmf-fleet-msgs \
    rmf-robot-sim-common \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-ros \
    gazebo-rosdev \
    geometry-msgs \
    libeigen \
    rclcpp \
    rmf-building-map-msgs \
    rmf-fleet-msgs \
    rmf-robot-sim-common \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmf_simulation-release/archive/release/foxy/rmf_robot_sim_gazebo_plugins/1.3.1-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/rmf_robot_sim_gazebo_plugins"
SRC_URI = "git://github.com/ros2-gbp/rmf_simulation-release;${ROS_BRANCH};protocol=https"
SRCREV = "2a343b21a904e8f8111d4aa66ab35eba6275e15d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
