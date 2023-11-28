# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "<p>     A wrapper around Polar Scan Matcher by Albert Diosi and Lindsay Kleeman, used for laser scan registration.     </p>"
AUTHOR = "Ivan Dryanovski <ccnyroboticslab@gmail.com>"
ROS_AUTHOR = "Ivan Dryanovski"
HOMEPAGE = "http://ros.org/wiki/polar_scan_matcher"
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=162b49cfbae9eadf37c9b89b2d2ac6be"

ROS_CN = "scan_tools"
ROS_BPN = "polar_scan_matcher"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    roscpp \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    roscpp \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    roscpp \
    sensor-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/scan_tools-release/archive/release/noetic/polar_scan_matcher/0.4.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/polar_scan_matcher"
SRC_URI = "git://github.com/ros-gbp/scan_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "19cc6b2b46d30db498f2893cd7557a21510b9df7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
