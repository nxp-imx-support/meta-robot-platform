# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Drive-by-wire interface to the Dataspeed Inc. Ford DBW kit"
AUTHOR = "Kevin Hallenbeck <khallenbeck@dataspeedinc.com>"
ROS_AUTHOR = "Kevin Hallenbeck <khallenbeck@dataspeedinc.com>"
HOMEPAGE = "http://dataspeedinc.com"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "dbw_ros"
ROS_BPN = "dbw_ford_can"

ROS_BUILD_DEPENDS = " \
    can-msgs \
    dataspeed-can-msg-filters \
    dataspeed-dbw-common \
    dbw-ford-msgs \
    geometry-msgs \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    can-msgs \
    dataspeed-dbw-common \
    dbw-ford-msgs \
    geometry-msgs \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-msgs \
    dataspeed-can-usb \
    dataspeed-dbw-common \
    dataspeed-dbw-gateway \
    dataspeed-ulc-can \
    dbw-ford-description \
    dbw-ford-msgs \
    geometry-msgs \
    rclcpp \
    sensor-msgs \
    std-msgs \
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

# matches with: https://github.com/DataspeedInc-release/dbw_ros-release/archive/release/foxy/dbw_ford_can/2.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/dbw_ford_can"
SRC_URI = "git://github.com/DataspeedInc-release/dbw_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "f22b21814f7c821022bf9a8cd259a9b65507f6b8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
