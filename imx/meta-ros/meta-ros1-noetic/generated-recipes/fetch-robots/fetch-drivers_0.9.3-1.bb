# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The public fetch_drivers package is a binary only release.      fetch_drivers contains both the drivers and firmware for the fetch and freight research robots.     There should be no reason to use these drivers unless you're running on a fetch or a freight research robot.     This package, is a cmake/make only package which installs the binaries for the drivers and firmware."
AUTHOR = "Carl Saldanha <csaldanha@fetchrobotics.com>"
ROS_AUTHOR = "Alexander Moriarty"
HOMEPAGE = "https://wiki.ros.org/fetch_drivers"
SECTION = "devel"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "fetch_robots"
ROS_BPN = "fetch_drivers"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    curl \
    diagnostic-msgs \
    fetch-auto-dock-msgs \
    fetch-driver-msgs \
    mk \
    nav-msgs \
    power-msgs \
    python3 \
    robot-calibration-msgs \
    robot-controllers \
    robot-controllers-interface \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rospack \
    rostime \
    sensor-msgs \
    urdf \
    urdfdom \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    curl \
    diagnostic-msgs \
    fetch-auto-dock-msgs \
    fetch-driver-msgs \
    nav-msgs \
    power-msgs \
    python3 \
    robot-calibration-msgs \
    robot-controllers \
    robot-controllers-interface \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rostime \
    sensor-msgs \
    urdf \
    urdfdom \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    curl \
    diagnostic-msgs \
    fetch-auto-dock-msgs \
    fetch-driver-msgs \
    nav-msgs \
    power-msgs \
    python3 \
    robot-calibration-msgs \
    robot-controllers \
    robot-controllers-interface \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rostime \
    sensor-msgs \
    urdf \
    urdfdom \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fetchrobotics-gbp/fetch_robots-release/archive/release/noetic/fetch_drivers/0.9.3-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/fetch_drivers"
SRC_URI = "git://github.com/fetchrobotics-gbp/fetch_robots-release;${ROS_BRANCH};protocol=https"
SRCREV = "49912cd02a33ab92188261118f79d497f8de35e4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
