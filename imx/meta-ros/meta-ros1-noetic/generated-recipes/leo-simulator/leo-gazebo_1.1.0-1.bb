# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Launch files and other resources for simulating Leo Rover in Gazebo."
AUTHOR = "Fictionlab <support@fictionlab.pl>"
ROS_AUTHOR = "Błażej Sowa <blazej@fictionlab.pl>"
HOMEPAGE = "http://wiki.ros.org/leo_gazebo"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "leo_simulator"
ROS_BPN = "leo_gazebo"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    compressed-image-transport \
    controller-manager \
    diff-drive-controller \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    geometry-msgs \
    joint-state-controller \
    leo-description \
    leo-gazebo-plugins \
    leo-gazebo-worlds \
    nav-msgs \
    robot-state-publisher \
    topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fictionlab-gbp/leo_simulator-release/archive/release/noetic/leo_gazebo/1.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/leo_gazebo"
SRC_URI = "git://github.com/fictionlab-gbp/leo_simulator-release;${ROS_BRANCH};protocol=https"
SRCREV = "92439bf890fce5174abc1e4f06ff058c6bfbcf41"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
