#
# Copyright Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The i.MX Aibot1 description ros package"
AUTHOR = "Xiaodong Zhang <xiaodong.zhang@nxp.com>"
HOMEPAGE = "https://www.nxp.com"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "imx_aibot1"
ROS_BPN = "imx_aibot1_description"

ROS_BUILD_DEPENDS = " \
    urdf \
    xacro \
"

ROS_BUILDTOOL_DEPENDS = " \
    ${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros1', 'catkin-native', '', d)} \
    ${@bb.utils.contains('ROS_DISTRO_TYPE', 'ros2', 'cmake-native', '', d)} \
"

ROS_EXPORT_DEPENDS = " \
    urdf \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = " file://imx-aibot1-description.tar.gz"

S = "${WORKDIR}/git" 

ROS_BUILD_TYPE = "${@bb.utils.contains('ROS_DISTRO_TYPE','ros1','catkin','ament_cmake',d)}"

inherit ros_${ROS_BUILD_TYPE}
