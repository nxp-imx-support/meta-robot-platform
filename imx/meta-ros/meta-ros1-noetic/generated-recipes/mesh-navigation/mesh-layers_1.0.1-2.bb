# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The mesh_layers package"
AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
ROS_AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD-3"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=ba717dc718040ac1636f383eca24f11f"

ROS_CN = "mesh_navigation"
ROS_BPN = "mesh_layers"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
    mesh-map \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    mesh-map \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    mesh-map \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/uos-gbp/mesh_navigation-release/archive/release/noetic/mesh_layers/1.0.1-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mesh_layers"
SRC_URI = "git://github.com/uos-gbp/mesh_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "f84e103521e495bbc15ca9d3b09aa2bae3e77e0d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
