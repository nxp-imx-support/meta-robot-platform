# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The ira_laser_tools package. These nodes are meant to provide some utils for lasers, like listen to different laser scan sources and merge them in a single scan or generate virtual laser scans from a pointcloud."
AUTHOR = "Augusto <augusto.ballardini@unimib.it>"
HOMEPAGE = "http://www.ros.org/wiki/ira_laser_tools"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ira_laser_tools"
ROS_BPN = "ira_laser_tools"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libvtk-qt} \
    laser-geometry \
    pcl \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libvtk-qt} \
    laser-geometry \
    pcl \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libvtk-qt} \
    laser-geometry \
    pcl \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/iralabdisco/ira_laser_tools-release/archive/release/noetic/ira_laser_tools/1.0.7-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ira_laser_tools"
SRC_URI = "git://github.com/iralabdisco/ira_laser_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "1cc47163845166df57d5794d33e1cf03fb1bdee7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
