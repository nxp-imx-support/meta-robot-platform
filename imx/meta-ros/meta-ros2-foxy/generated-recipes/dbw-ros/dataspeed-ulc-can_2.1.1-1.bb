# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Package to translate ROS messages to and from CAN messages to interact with the Universal Lat/Lon Controller (ULC) firmware"
AUTHOR = "Micho Radovnikovich <mradovnikovich@dataspeedinc.com>"
ROS_AUTHOR = "Micho Radovnikovich <mradovnikovich@dataspeedinc.com>"
HOMEPAGE = "http://dataspeedinc.com"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "dbw_ros"
ROS_BPN = "dataspeed_ulc_can"

ROS_BUILD_DEPENDS = " \
    can-msgs \
    dataspeed-dbw-common \
    dataspeed-ulc-msgs \
    geometry-msgs \
    rclcpp \
    rclpy \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    can-msgs \
    dataspeed-dbw-common \
    dataspeed-ulc-msgs \
    geometry-msgs \
    rclcpp \
    rclpy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-msgs \
    dataspeed-dbw-common \
    dataspeed-ulc-msgs \
    geometry-msgs \
    rclcpp \
    rclpy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ros-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/DataspeedInc-release/dbw_ros-release/archive/release/foxy/dataspeed_ulc_can/2.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/dataspeed_ulc_can"
SRC_URI = "git://github.com/DataspeedInc-release/dbw_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "78ac6470cba7da312f6a38df57d45dbedf66ecf3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
