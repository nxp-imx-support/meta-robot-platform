#
# Copyright Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package contains a recent version of the Bayesian Filtering   Library (BFL), distributed by the Orocos Project.  For stability   reasons, this package is currently locked to revision 31655 (April   19, 2010), but this revision will be updated on a regular basis to   the latest available BFL trunk.  This ROS package does not modify   BFL in any way, it simply provides a convenient way to download and   compile the library, because BFL is not available from an OS package   manager.  This ROS package compiles BFL with the Boost library for   matrix operations and random number generation."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Klaas Gadeyne, Wim Meeussen, Tinne Delaet and many others. See web page for a full contributor list. ROS package maintained by Wim Meeussen."
HOMEPAGE = "http://ros.org/wiki/bfl"
SECTION = "devel"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=46ee8693f40a89a31023e97ae17ecf19"

ROS_CN = "bfl"
ROS_BPN = "bfl"

ROS_BUILD_DEPENDS = " \
    cppunit \
    ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros1', 'catkin-native', '', d)} \
    ${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros2', 'cmake-native', '', d)} \
"

ROS_EXPORT_DEPENDS = " \
    catkin \
    cppunit \
    ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    catkin \
    cppunit \
    ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/bfl-release/archive/release/melodic/bfl/0.8.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/bfl"
SRC_URI = "git://github.com/ros-gbp/bfl-release;${ROS_BRANCH};protocol=https"
SRCREV = "c890914642b5d2bd91a57b18b40786caa63bb9f3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "${@bb.utils.contains('ROS_DISTRO_TYPE','ros1','catkin','cmake',d)}"

inherit ros_${ROS_BUILD_TYPE}
