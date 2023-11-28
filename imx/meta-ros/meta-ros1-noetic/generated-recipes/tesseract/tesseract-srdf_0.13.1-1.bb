# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The tesseract_srdf package for parsing Tesseract specific srdf"
AUTHOR = "Levi Armstrong <levi.armstrong@swri.org>"
ROS_AUTHOR = "Levi Armstrong"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "tesseract"
ROS_BPN = "tesseract_srdf"

ROS_BUILD_DEPENDS = " \
    console-bridge \
    libeigen \
    ros-industrial-cmake-boilerplate \
    tesseract-common \
    tesseract-scene-graph \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    console-bridge \
    libeigen \
    tesseract-common \
    tesseract-scene-graph \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    console-bridge \
    tesseract-common \
    tesseract-scene-graph \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    gtest \
    tesseract-support \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/tesseract-release/archive/release/noetic/tesseract_srdf/0.13.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/tesseract_srdf"
SRC_URI = "git://github.com/ros-industrial-release/tesseract-release;${ROS_BRANCH};protocol=https"
SRCREV = "dede646fbf870683f5d7e3e7f59c37ac77177e9f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
