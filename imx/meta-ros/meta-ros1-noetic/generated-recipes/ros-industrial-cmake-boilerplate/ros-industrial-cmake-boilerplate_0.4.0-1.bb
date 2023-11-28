# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Contains boilerplate cmake script, macros and utils"
AUTHOR = "Levi Armstrong <Levi.Armstrong@swri.org>"
ROS_AUTHOR = "Levi Armstrong"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0 & BSD 3-Clause"
LICENSE = "Apache-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "ros_industrial_cmake_boilerplate"
ROS_BPN = "ros_industrial_cmake_boilerplate"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-iwyu} \
    ${ROS_UNRESOLVED_DEP-libclang-dev} \
    cppcheck \
    gtest \
    lcov \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/ros_industrial_cmake_boilerplate-release/archive/release/noetic/ros_industrial_cmake_boilerplate/0.4.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ros_industrial_cmake_boilerplate"
SRC_URI = "git://github.com/ros-industrial-release/ros_industrial_cmake_boilerplate-release;${ROS_BRANCH};protocol=https"
SRCREV = "c82d9a4c2e8d225b9dff2028bfbafc7eeadbd8d5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
