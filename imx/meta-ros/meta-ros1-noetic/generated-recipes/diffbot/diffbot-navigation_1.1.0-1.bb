# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The diffbot_navigation package"
AUTHOR = "fjp <ros@fjp.at>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSDv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "diffbot"
ROS_BPN = "diffbot_navigation"

ROS_BUILD_DEPENDS = " \
    amcl \
    diffbot-bringup \
    map-server \
    move-base \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    amcl \
    diffbot-bringup \
    map-server \
    move-base \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    amcl \
    base-local-planner \
    diffbot-bringup \
    dwa-local-planner \
    map-server \
    move-base \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-mobile-robots-release/diffbot-release/archive/release/noetic/diffbot_navigation/1.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/diffbot_navigation"
SRC_URI = "git://github.com/ros-mobile-robots-release/diffbot-release;${ROS_BRANCH};protocol=https"
SRCREV = "d8b4ccebf9f7e0d6015cdee3d2a5ccd7da4da59d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
