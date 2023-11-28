# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "PMB2-specific launch files needed to run     navigation on the PMB2 robot."
AUTHOR = "Victor Lopez <victor.lopez@pal-robotics.com>"
ROS_AUTHOR = "Victor Lopez <victor.lopez@pal-robotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Modified BSD"
LICENSE = "Modified-BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=9fe507396161b9e47d2b1e01c422787a"

ROS_CN = "pmb2_simulation"
ROS_BPN = "pmb2_2dnav_gazebo"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pmb2-2dnav \
    pmb2-gazebo \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pal-gbp/pmb2_simulation-gbp/archive/release/foxy/pmb2_2dnav_gazebo/3.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/pmb2_2dnav_gazebo"
SRC_URI = "git://github.com/pal-gbp/pmb2_simulation-gbp;${ROS_BRANCH};protocol=https"
SRCREV = "09ad4e9534bc789600048a54a87cd530adf8987a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
