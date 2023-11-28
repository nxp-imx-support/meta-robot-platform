# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "This package contains a recent version of the Kinematics and Dynamics     Library (KDL), distributed by the Orocos Project."
AUTHOR = "Ivan Paunovic <ivanpauno@ekumenlabs.com>"
ROS_AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
HOMEPAGE = "http://wiki.ros.org/orocos_kdl"
SECTION = "devel"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d94c5c8f30151b2fe7d07ba53ed6444b"

ROS_CN = "orocos_kinematics_dynamics"
ROS_BPN = "orocos_kdl"

ROS_BUILD_DEPENDS = " \
    libeigen \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
    eigen3-cmake-module-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    eigen3-cmake-module-native \
"

ROS_EXEC_DEPENDS = " \
    pkgconfig \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    cppunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/orocos_kinematics_dynamics-release/archive/release/foxy/orocos_kdl/3.3.5-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/orocos_kdl"
SRC_URI = "git://github.com/ros2-gbp/orocos_kinematics_dynamics-release;${ROS_BRANCH};protocol=https"
SRCREV = "b7ab05b648ea43a5cf1fa3fa63afdc4a4f3d3cab"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
