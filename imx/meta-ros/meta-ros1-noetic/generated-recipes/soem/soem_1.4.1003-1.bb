# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "ROS wrapper for the Simple Open EtherCAT Master SOEM.     This is an updated version of the original SOEM wrapper released into ROS now including     the upstream Repo as a git subtree."
AUTHOR = "Matthias Gruhler <matthias.gruhler@gmail.com>"
ROS_AUTHOR = "Arthur Ketels and M.J.G. van den Molengraft"
HOMEPAGE = "http://openethercatsociety.github.io/"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv2 with linking exception"
LICENSE = "GPLv2-with-linking-exception"
LIC_FILES_CHKSUM = "file://package.xml;beginline=31;endline=31;md5=321c016bc6284feaf25be31c1c1365e6"

ROS_CN = "soem"
ROS_BPN = "soem"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/mgruhler/soem-gbp/archive/release/noetic/soem/1.4.1003-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/soem"
SRC_URI = "git://github.com/mgruhler/soem-gbp;${ROS_BRANCH};protocol=https"
SRCREV = "1a2578f7faa42927526796e84e0c998086b2344f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
