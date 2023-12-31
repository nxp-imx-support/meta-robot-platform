# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Maliput bindings"
AUTHOR = "Andrew Best <andrew.best@tri.global>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD Clause 3"
LICENSE = "BSD-Clause-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=e2197b8633fd51a47f897d9d6f820c24"

ROS_CN = "maliput_py"
ROS_BPN = "maliput_py"

ROS_BUILD_DEPENDS = " \
    maliput \
    python3 \
    python3-pybind11 \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    maliput \
    python3-pybind11 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    maliput \
    python3-pybind11 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-clang-format \
    ament-cmake-flake8 \
    ament-cmake-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/maliput_py-release/archive/release/foxy/maliput_py/0.1.5-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/maliput_py"
SRC_URI = "git://github.com/ros2-gbp/maliput_py-release;${ROS_BRANCH};protocol=https"
SRCREV = "8496919ffa9b3fb4045787fdb35704f1ef88a1cf"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
