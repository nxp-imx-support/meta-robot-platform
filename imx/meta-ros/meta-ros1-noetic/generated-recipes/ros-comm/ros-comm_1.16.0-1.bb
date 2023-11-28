# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "ROS communications-related packages, including core client libraries (roscpp, rospy) and graph introspection tools (rostopic, rosnode, rosservice, rosparam)."
AUTHOR = "Michael Carroll <michael@openrobotics.org>"
ROS_AUTHOR = "Morgan Quigley <mquigley@cs.stanford.edu>"
HOMEPAGE = "http://wiki.ros.org/ros_comm"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_comm"
ROS_BPN = "ros_comm"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-filters \
    ros \
    rosbag \
    rosconsole \
    roscpp \
    rosgraph \
    rosgraph-msgs \
    roslaunch \
    roslisp \
    rosmaster \
    rosmsg \
    rosnode \
    rosout \
    rosparam \
    rospy \
    rosservice \
    rostest \
    rostopic \
    roswtf \
    std-srvs \
    topic-tools \
    xmlrpcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-filters \
    ros \
    rosbag \
    rosconsole \
    roscpp \
    rosgraph \
    rosgraph-msgs \
    roslaunch \
    roslisp \
    rosmaster \
    rosmsg \
    rosnode \
    rosout \
    rosparam \
    rospy \
    rosservice \
    rostest \
    rostopic \
    roswtf \
    std-srvs \
    topic-tools \
    xmlrpcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/ros_comm-release/archive/release/noetic/ros_comm/1.16.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ros_comm"
SRC_URI = "git://github.com/ros-gbp/ros_comm-release;${ROS_BRANCH};protocol=https"
SRCREV = "4fcc4825c4116812195fab0cce207dd701e412bf"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
