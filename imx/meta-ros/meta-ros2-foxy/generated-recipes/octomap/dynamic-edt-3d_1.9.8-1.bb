# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "The dynamicEDT3D library implements an inrementally updatable Euclidean distance transform (EDT) in 3D. It comes with a wrapper to use the OctoMap 3D representation and hooks into the change detection of the OctoMap library to propagate changes to the EDT."
AUTHOR = "Christoph Sprunk <sprunkc@informatik.uni-freiburg.de>"
ROS_AUTHOR = "Christoph Sprunk <sprunkc@informatik.uni-freiburg.de>"
HOMEPAGE = "http://octomap.github.io"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "octomap"
ROS_BPN = "dynamic_edt_3d"

ROS_BUILD_DEPENDS = " \
    octomap \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    octomap \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    octomap \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/octomap-release/archive/release/foxy/dynamic_edt_3d/1.9.8-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/dynamic_edt_3d"
SRC_URI = "git://github.com/ros-gbp/octomap-release;${ROS_BRANCH};protocol=https"
SRCREV = "55ac46c88b692bb23e020b27b3d79b2c2cf22723"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
