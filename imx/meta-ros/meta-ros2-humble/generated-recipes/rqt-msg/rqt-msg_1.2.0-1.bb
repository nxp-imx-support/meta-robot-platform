# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "A Python GUI plugin for introspecting available ROS message types.   Note that the msgs available through this plugin is the ones that are stored   on your machine, not on the ROS core your rqt instance connects to."
AUTHOR = "Audrow Nash <audrow@openrobotics.org>"
ROS_AUTHOR = "Aaron Blasdel"
HOMEPAGE = "http://wiki.ros.org/rqt_msg"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_msg"
ROS_BPN = "rqt_msg"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    python-qt-binding \
    python3-catkin-pkg \
    rclpy \
    rqt-console \
    rqt-gui \
    rqt-gui-py \
    rqt-py-common \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rqt_msg-release/archive/release/humble/rqt_msg/1.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/rqt_msg"
SRC_URI = "git://github.com/ros2-gbp/rqt_msg-release;${ROS_BRANCH};protocol=https"
SRCREV = "de089c4bcaf5ad5ecbfc65cd387f526812330c08"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
