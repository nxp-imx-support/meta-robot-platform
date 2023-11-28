# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The cob_frame_tracker package contains nodes that publish Twist commands based on the distance to the desired tf frame target."
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
ROS_AUTHOR = "Felix Messmer <fxm@ipa.fhg.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_control"
ROS_BPN = "cob_frame_tracker"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    cob-srvs \
    control-toolbox \
    dynamic-reconfigure \
    geometry-msgs \
    interactive-markers \
    kdl-conversions \
    kdl-parser \
    message-generation \
    orocos-kdl \
    roscpp \
    roslint \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    cob-srvs \
    control-toolbox \
    dynamic-reconfigure \
    geometry-msgs \
    interactive-markers \
    kdl-conversions \
    kdl-parser \
    orocos-kdl \
    roscpp \
    roslint \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    cob-srvs \
    control-toolbox \
    dynamic-reconfigure \
    geometry-msgs \
    interactive-markers \
    kdl-conversions \
    kdl-parser \
    message-runtime \
    orocos-kdl \
    roscpp \
    roslint \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa320/cob_control-release/archive/release/noetic/cob_frame_tracker/0.8.21-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/cob_frame_tracker"
SRC_URI = "git://github.com/ipa320/cob_control-release;${ROS_BRANCH};protocol=https"
SRCREV = "eebfc0a8072320122438f77981bcf8ccaba8be82"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
