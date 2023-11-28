# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This package provides a sped up improved slam karto with updated SDK and visualization and modification toolsets"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
ROS_AUTHOR = "Steve Macenski"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=46ee8693f40a89a31023e97ae17ecf19"

ROS_CN = "slam_toolbox"
ROS_BPN = "slam_toolbox_rviz"

ROS_BUILD_DEPENDS = " \
    qtbase \
    rviz \
    slam-toolbox-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    qtbase \
    rviz \
    slam-toolbox-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    qtbase \
    rviz \
    slam-toolbox-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/slam_toolbox-release/archive/release/noetic/slam_toolbox_rviz/1.5.7-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/slam_toolbox_rviz"
SRC_URI = "git://github.com/SteveMacenski/slam_toolbox-release;${ROS_BRANCH};protocol=https"
SRCREV = "32f46a0698d027b5e9e43654062ae22f9e6c703c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
