# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "grep for ROS bag files and live topics"
AUTHOR = "Erki Suurjaak <erki@lap.ee>"
ROS_AUTHOR = "Erki Suurjaak <erki@lap.ee>"
HOMEPAGE = "http://www.ros.org/wiki/grepros"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "grepros"
ROS_BPN = "grepros"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    python3-pyyaml \
    rclpy \
    rosidl-parser \
    rosidl-runtime-py \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    python3-pyyaml \
    rclpy \
    rosidl-parser \
    rosidl-runtime-py \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    python3-pyyaml \
    rclpy \
    rosidl-parser \
    rosidl-runtime-py \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-pytest \
    python3-pytest \
    std-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/suurjaak/grepros-release/archive/release/foxy/grepros/0.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/grepros"
SRC_URI = "git://github.com/suurjaak/grepros-release;${ROS_BRANCH};protocol=https"
SRCREV = "ed3f158d2ed40540b3046f7a1388b4498a4a688b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}