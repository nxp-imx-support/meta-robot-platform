# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Provides a ublox_gnss node for a u-blox GPS GNSS receiver using Gen 9 UBX Protocol"
AUTHOR = "Nick Hortovanyi <nick@aussierobots.com.au>"
HOMEPAGE = "https://github.com/aussierobots/ublox_dgnss"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License, Version 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=e8978a5103d23266fc6f8ec03dc9eb16"

ROS_CN = "ublox_dgnss"
ROS_BPN = "ublox_dgnss_node"

ROS_BUILD_DEPENDS = " \
    libusb1 \
    pkgconfig \
    rclcpp \
    rclcpp-components \
    ublox-ubx-interfaces \
    ublox-ubx-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    libusb1 \
    rclcpp \
    rclcpp-components \
    ublox-ubx-interfaces \
    ublox-ubx-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libusb1 \
    rclcpp \
    rclcpp-components \
    std-msgs \
    ublox-ubx-interfaces \
    ublox-ubx-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-copyright \
    ament-cmake-cppcheck \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ublox_dgnss-release/archive/release/humble/ublox_dgnss_node/0.3.5-4.tar.gz
ROS_BRANCH ?= "branch=release/humble/ublox_dgnss_node"
SRC_URI = "git://github.com/ros2-gbp/ublox_dgnss-release;${ROS_BRANCH};protocol=https"
SRCREV = "1abccde51ccd3fb8f6e1cc1be62af06f998df523"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
