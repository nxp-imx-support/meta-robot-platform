# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The diffbot_base package"
AUTHOR = "Franz Pucher <fp@fjp.at>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSDv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "diffbot"
ROS_BPN = "diffbot_base"

ROS_BUILD_DEPENDS = " \
    control-toolbox \
    controller-manager \
    diagnostic-updater \
    diff-drive-controller \
    diffbot-msgs \
    dynamic-reconfigure \
    hardware-interface \
    roscpp \
    rosparam-shortcuts \
    sensor-msgs \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    control-toolbox \
    controller-manager \
    diagnostic-updater \
    diff-drive-controller \
    diffbot-msgs \
    dynamic-reconfigure \
    hardware-interface \
    roscpp \
    rosparam-shortcuts \
    sensor-msgs \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    control-toolbox \
    controller-manager \
    diagnostic-updater \
    diff-drive-controller \
    diffbot-msgs \
    dynamic-reconfigure \
    hardware-interface \
    roscpp \
    rosparam-shortcuts \
    rosserial \
    sensor-msgs \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-mobile-robots-release/diffbot-release/archive/release/noetic/diffbot_base/1.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/diffbot_base"
SRC_URI = "git://github.com/ros-mobile-robots-release/diffbot-release;${ROS_BRANCH};protocol=https"
SRCREV = "36b12b29d3258f7ac21099f2e5208e677a5f6b2c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
