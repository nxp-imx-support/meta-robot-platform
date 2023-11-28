# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "AeroStack2 drone interface tool in python"
AUTHOR = "Computer Vision And Aerial Robotics Group (UPM) <cvar.upm3@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "aerostack2"
ROS_BPN = "as2_python_api"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-pymap3d} \
    action-msgs \
    as2-motion-reference-handlers \
    as2-msgs \
    geographic-msgs \
    geometry-msgs \
    nav-msgs \
    rclpy \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-pymap3d} \
    action-msgs \
    as2-motion-reference-handlers \
    as2-msgs \
    geographic-msgs \
    geometry-msgs \
    nav-msgs \
    rclpy \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-pymap3d} \
    action-msgs \
    as2-motion-reference-handlers \
    as2-msgs \
    geographic-msgs \
    geometry-msgs \
    nav-msgs \
    rclpy \
    sensor-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/aerostack2-release/archive/release/humble/as2_python_api/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/as2_python_api"
SRC_URI = "git://github.com/ros2-gbp/aerostack2-release;${ROS_BRANCH};protocol=https"
SRCREV = "075a646bc284810d43a6dce92174823c802c55d1"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}