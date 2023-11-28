# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "The class_loader package is a ROS-independent package for loading plugins during runtime and the foundation of the higher level ROS &quot;pluginlib&quot; library.     class_loader utilizes the host operating system's runtime loader to open runtime libraries (e.g. .so/.dll files), introspect the library for exported plugin classes, and allows users to instantiate objects of these exported classes without the explicit declaration (i.e. header file) for those classes."
AUTHOR = "Steven! Ragnarök <stevenragnarok@osrfoundation.org>"
ROS_AUTHOR = "Mirza Shah"
HOMEPAGE = "http://ros.org/wiki/class_loader"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "class_loader"
ROS_BPN = "class_loader"

ROS_BUILD_DEPENDS = " \
    console-bridge \
    console-bridge-vendor \
    rcpputils \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rcpputils \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    console-bridge \
    console-bridge-vendor \
    rcpputils \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/class_loader-release/archive/release/foxy/class_loader/2.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/class_loader"
SRC_URI = "git://github.com/ros2-gbp/class_loader-release;${ROS_BRANCH};protocol=https"
SRCREV = "7a29e7f601d6bc5993012bd60dec2c01dcb0a588"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
