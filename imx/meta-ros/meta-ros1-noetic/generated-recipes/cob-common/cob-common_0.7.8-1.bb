# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The cob_common stack hosts common packages that are used within the Care-O-bot repository. E.g. utility packages or common message and service definitions etc. Also the urdf desciption of the robot is located in this stack."
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/cob_common"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=5;endline=5;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_common"
ROS_BPN = "cob_common"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cob-actions \
    cob-description \
    cob-msgs \
    cob-srvs \
    raw-description \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa320/cob_common-release/archive/release/noetic/cob_common/0.7.8-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/cob_common"
SRC_URI = "git://github.com/ipa320/cob_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "d129407df31e8bdb2d44d2793f66f41d9a9da56b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
