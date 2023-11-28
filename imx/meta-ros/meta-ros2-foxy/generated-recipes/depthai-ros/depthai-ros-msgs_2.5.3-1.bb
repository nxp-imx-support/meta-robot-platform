# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Package to keep interface independent of the driver"
AUTHOR = "Sachin Guruswamy <sachin@luxonis.com>"
ROS_AUTHOR = "Sachin Guruswamy"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "depthai-ros"
ROS_BPN = "depthai_ros_msgs"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    rclcpp \
    rosidl-default-generators \
    sensor-msgs \
    std-msgs \
    vision-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    rclcpp \
    rosidl-default-generators \
    sensor-msgs \
    std-msgs \
    vision-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    rclcpp \
    rosidl-default-generators \
    sensor-msgs \
    std-msgs \
    vision-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/luxonis/depthai-ros-release/archive/release/foxy/depthai_ros_msgs/2.5.3-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/depthai_ros_msgs"
SRC_URI = "git://github.com/luxonis/depthai-ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "1d105d9b8ed06f402a64dff031037f3c2c0082c6"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
