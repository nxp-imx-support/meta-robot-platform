# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The sr_hand_detector package"
AUTHOR = "Shadow Robot's Software Team <software@shadowrobot.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=162b49cfbae9eadf37c9b89b2d2ac6be"

ROS_CN = "sr_hand_detector"
ROS_BPN = "sr_hand_detector"

ROS_BUILD_DEPENDS = " \
    roscpp \
    roslib \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    roslib \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/shadow-robot/sr_hand_detector-release/archive/release/noetic/sr_hand_detector/0.0.9-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/sr_hand_detector"
SRC_URI = "git://github.com/shadow-robot/sr_hand_detector-release;${ROS_BRANCH};protocol=https"
SRCREV = "b62ea67d7cb755dea72b57744660538d897b65bf"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
