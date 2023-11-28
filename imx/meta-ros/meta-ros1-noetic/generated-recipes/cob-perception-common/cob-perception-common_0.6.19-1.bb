# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This stack provides utilities commonly needed for a variety of computer vision tasks."
AUTHOR = "Richard Bormann <rmb@ipa.fhg.de>"
HOMEPAGE = "http://wiki.ros.org/cob_perception_common"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_perception_common"
ROS_BPN = "cob_perception_common"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cob-3d-mapping-msgs \
    cob-cam3d-throttle \
    cob-image-flip \
    cob-object-detection-msgs \
    cob-object-detection-visualizer \
    cob-perception-msgs \
    cob-vision-utils \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa320/cob_perception_common-release/archive/release/noetic/cob_perception_common/0.6.19-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/cob_perception_common"
SRC_URI = "git://github.com/ipa320/cob_perception_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "fbd4ea831e9fa1eae4d6260420984692d0a7ae08"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
