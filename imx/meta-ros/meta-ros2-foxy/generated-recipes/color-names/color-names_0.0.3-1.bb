# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "The color_names package"
AUTHOR = "masaya <ms.kataoka@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "color_names"
ROS_BPN = "color_names"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rviz2 \
    std-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    rviz2 \
    std-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rviz2 \
    std-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ouxt-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/OUXT-Polaris/color_names-release/archive/release/foxy/color_names/0.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/color_names"
SRC_URI = "git://github.com/OUXT-Polaris/color_names-release;${ROS_BRANCH};protocol=https"
SRCREV = "d99996347b67373aa3f8cde318dc734b1066eed4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
