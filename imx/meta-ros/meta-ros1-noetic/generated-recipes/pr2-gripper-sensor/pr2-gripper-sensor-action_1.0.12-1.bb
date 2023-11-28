# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The pr2_gripper_sensor_action package provides an action interface for talking to the pr2_gripper_sensor_controller real-time controller.    It provides several different actions for getting high-level sensor information from the PR2 palm-mounted accelerometers, fingertip pressure arrays, and gripper motor/encoder, as well as several sensor-based gripper control actions that respond with low-latency in real-time."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Joe Romano"
HOMEPAGE = "None"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_gripper_sensor"
ROS_BPN = "pr2_gripper_sensor_action"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    message-generation \
    pr2-controllers-msgs \
    pr2-gripper-sensor-controller \
    pr2-gripper-sensor-msgs \
    pr2-machine \
    pr2-mechanism-controllers \
    pr2-mechanism-model \
    robot-mechanism-controllers \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    message-runtime \
    pr2-controllers-msgs \
    pr2-gripper-sensor-controller \
    pr2-gripper-sensor-msgs \
    pr2-machine \
    pr2-mechanism-controllers \
    pr2-mechanism-model \
    robot-mechanism-controllers \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    message-runtime \
    pr2-controllers-msgs \
    pr2-gripper-sensor-controller \
    pr2-gripper-sensor-msgs \
    pr2-machine \
    pr2-mechanism-controllers \
    pr2-mechanism-model \
    robot-mechanism-controllers \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_gripper_sensor-release/archive/release/noetic/pr2_gripper_sensor_action/1.0.12-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pr2_gripper_sensor_action"
SRC_URI = "git://github.com/pr2-gbp/pr2_gripper_sensor-release;${ROS_BRANCH};protocol=https"
SRCREV = "32087b466782f676669e274e0e9a6233af4bbd31"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
