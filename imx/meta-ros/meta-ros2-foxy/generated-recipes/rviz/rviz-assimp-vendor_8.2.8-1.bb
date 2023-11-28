# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Wrapper around assimp, providing nothing but a dependency on assimp, on some systems.     On others, it provides a fixed CMake module or even an ExternalProject build of assimp."
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
ROS_AUTHOR = "William Woodall <william@osrfoundation.org>"
HOMEPAGE = "http://assimp.sourceforge.net/index.html"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0 & BSD"
LICENSE = "Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=f12ef8c0445c08084ae92cf2dcb7ee92"

ROS_CN = "rviz"
ROS_BPN = "rviz_assimp_vendor"

ROS_BUILD_DEPENDS = " \
    assimp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rviz-release/archive/release/foxy/rviz_assimp_vendor/8.2.8-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/rviz_assimp_vendor"
SRC_URI = "git://github.com/ros2-gbp/rviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "2f9aefeb62be6ffcf36bae7d98ede71dd479f009"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
