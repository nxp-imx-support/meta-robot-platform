# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "A ROS2 Driver for V4L USB Cameras"
AUTHOR = "Evan Flynn <evanflynn.msu@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/usb_cam"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "usb_cam"
ROS_BPN = "usb_cam"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    camera-info-manager \
    cv-bridge \
    ffmpeg \
    image-transport \
    image-transport-plugins \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
    std-srvs \
    v4l-utils \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    camera-info-manager \
    cv-bridge \
    ffmpeg \
    image-transport \
    image-transport-plugins \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
    std-srvs \
    v4l-utils \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    camera-info-manager \
    cv-bridge \
    ffmpeg \
    image-transport \
    image-transport-plugins \
    rclcpp \
    rclcpp-components \
    rosidl-default-runtime \
    sensor-msgs \
    std-msgs \
    std-srvs \
    v4l-utils \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/usb_cam-release/archive/release/foxy/usb_cam/0.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/usb_cam"
SRC_URI = "git://github.com/ros-gbp/usb_cam-release;${ROS_BRANCH};protocol=https"
SRCREV = "9fc5e468fc432613d9af5776cd827db1879d1259"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}