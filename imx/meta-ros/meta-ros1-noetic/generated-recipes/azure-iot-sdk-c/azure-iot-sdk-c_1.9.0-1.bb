# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Azure IoT C SDKs and Libraries"
AUTHOR = "Tim Clephas <tim.clephas@nobleo.nl>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "azure-iot-sdk-c"
ROS_BPN = "azure-iot-sdk-c"

ROS_BUILD_DEPENDS = " \
    curl \
    openssl \
    util-linux \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    curl \
    openssl \
    util-linux \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    curl \
    openssl \
    util-linux \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/nobleo/azure-iot-sdk-c-release/archive/release/noetic/azure-iot-sdk-c/1.9.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/azure-iot-sdk-c"
SRC_URI = "git://github.com/nobleo/azure-iot-sdk-c-release;${ROS_BRANCH};protocol=https"
SRCREV = "9ad1ff6396dca65757b1525faba08af25ac20d9b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
