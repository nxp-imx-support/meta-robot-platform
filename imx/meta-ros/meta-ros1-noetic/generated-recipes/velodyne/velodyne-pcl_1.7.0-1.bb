# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The velodyne_pcl package"
AUTHOR = "Josh Whitley <josh.whitley@autoware.org>"
ROS_AUTHOR = "Sebastian Pütz"
HOMEPAGE = "http://wiki.ros.org/velodyne_pcl"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "velodyne"
ROS_BPN = "velodyne_pcl"

ROS_BUILD_DEPENDS = " \
    pcl-ros \
    roslint \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    pcl-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pcl-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/velodyne-release/archive/release/noetic/velodyne_pcl/1.7.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/velodyne_pcl"
SRC_URI = "git://github.com/ros-drivers-gbp/velodyne-release;${ROS_BRANCH};protocol=https"
SRCREV = "c8df29fd230b2991fa906fc458eedb8c98f132d5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
