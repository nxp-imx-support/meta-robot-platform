# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "API and ROS drivers for Phidgets devices"
AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
ROS_AUTHOR = "Phidgets Inc."
HOMEPAGE = "http://ros.org/wiki/phidgets_drivers"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD, LGPL"
LICENSE = "BSD-&-LGPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=9b8b2c2c843b0cb5803c38944da723d5"

ROS_CN = "phidgets_drivers"
ROS_BPN = "phidgets_drivers"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libphidget22 \
    phidgets-accelerometer \
    phidgets-analog-inputs \
    phidgets-api \
    phidgets-digital-inputs \
    phidgets-digital-outputs \
    phidgets-gyroscope \
    phidgets-high-speed-encoder \
    phidgets-ik \
    phidgets-magnetometer \
    phidgets-motors \
    phidgets-msgs \
    phidgets-spatial \
    phidgets-temperature \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/phidgets_drivers-release/archive/release/humble/phidgets_drivers/2.3.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/phidgets_drivers"
SRC_URI = "git://github.com/ros2-gbp/phidgets_drivers-release;${ROS_BRANCH};protocol=https"
SRCREV = "2cb67172bc242efe37a8b0816ece3698d7289156"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
