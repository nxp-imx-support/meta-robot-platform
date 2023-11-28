# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "RT Manipulators C++ Library"
AUTHOR = "RT Corporation <support@rt-net.jp>"
ROS_AUTHOR = "ShotaAk <s.aoki@rt-net.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rt_manipulators_cpp"
ROS_BPN = "rt_manipulators_cpp"

ROS_BUILD_DEPENDS = " \
    dynamixel-sdk \
    eigen3-cmake-module \
    libeigen \
    yaml-cpp \
    yaml-cpp-vendor \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamixel-sdk \
    eigen3-cmake-module \
    libeigen \
    yaml-cpp \
    yaml-cpp-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamixel-sdk \
    eigen3-cmake-module \
    libeigen \
    yaml-cpp \
    yaml-cpp-vendor \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/rt-net-gbp/rt_manipulators_cpp-release/archive/release/foxy/rt_manipulators_cpp/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/rt_manipulators_cpp"
SRC_URI = "git://github.com/rt-net-gbp/rt_manipulators_cpp-release;${ROS_BRANCH};protocol=https"
SRCREV = "293af9fa3b9089c131ee2031c520a1c8af1ed201"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
