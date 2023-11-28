# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This package contains configuration for each robot instance (e.g. cob4-X, raw3-X). There is a directory for each robot with configuration about urdf and hardware/device configurations."
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
ROS_AUTHOR = "Felix Messmer <fxm@ipa.fhg.de>"
HOMEPAGE = "http://ros.org/wiki/cob_hardware_config"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_robots"
ROS_BPN = "cob_hardware_config"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cob-calibration-data \
    cob-description \
    cob-omni-drive-controller \
    costmap-2d \
    diagnostic-aggregator \
    joint-state-controller \
    joint-state-publisher \
    joint-state-publisher-gui \
    joint-trajectory-controller \
    laser-filters \
    position-controllers \
    raw-description \
    robot-state-publisher \
    rviz \
    velocity-controllers \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    cob-supported-robots \
    roslaunch \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa320/cob_robots-release/archive/release/noetic/cob_hardware_config/0.7.9-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/cob_hardware_config"
SRC_URI = "git://github.com/ipa320/cob_robots-release;${ROS_BRANCH};protocol=https"
SRCREV = "6259826ec4da7bcf70387f2580d23a598978a4cb"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
