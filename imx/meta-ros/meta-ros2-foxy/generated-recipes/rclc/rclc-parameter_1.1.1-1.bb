# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Parameter server implementation for micro-ROS nodes"
AUTHOR = "Antonio Cuadros <antoniocuadros@eprosima.com>"
ROS_AUTHOR = "Antonio Cuadros <antoniocuadros@eprosima.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rclc"
ROS_BPN = "rclc_parameter"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    rcl \
    rcl-interfaces \
    rclc \
    rcutils \
    rosidl-runtime-c \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    rcl \
    rcl-interfaces \
    rclc \
    rcutils \
    rosidl-runtime-c \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    rcl \
    rcl-interfaces \
    rclc \
    rcutils \
    rosidl-runtime-c \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
    example-interfaces \
    osrf-testing-tools-cpp \
    rclcpp \
    std-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rclc-release/archive/release/foxy/rclc_parameter/1.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/rclc_parameter"
SRC_URI = "git://github.com/ros2-gbp/rclc-release;${ROS_BRANCH};protocol=https"
SRCREV = "505641eab4fb40fdd04119d463ed2ec23af06cf9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}