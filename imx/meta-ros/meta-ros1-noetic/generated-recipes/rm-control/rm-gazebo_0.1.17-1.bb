# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A template for ROS packages."
AUTHOR = "Qiayuan Liao <liaoqiayuan@gmail.com>"
ROS_AUTHOR = "Qiayuan Liao <liaoqiayuan@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "rm_control"
ROS_BPN = "rm_gazebo"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-gazebo} \
    gazebo-ros \
    gazebo-ros-control \
    rm-common \
    roscpp \
    roslint \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-gazebo} \
    gazebo-ros \
    gazebo-ros-control \
    rm-common \
    roscpp \
    roslint \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-gazebo} \
    gazebo-ros \
    gazebo-ros-control \
    rm-common \
    rm-description \
    roboticsgroup-upatras-gazebo-plugins \
    roscpp \
    roslint \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/rm-controls/rm_control-release/archive/release/noetic/rm_gazebo/0.1.17-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rm_gazebo"
SRC_URI = "git://github.com/rm-controls/rm_control-release;${ROS_BRANCH};protocol=https"
SRCREV = "2828f353d2fddd3cf6b5aafcb3a6fd51e7e2ea1b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
