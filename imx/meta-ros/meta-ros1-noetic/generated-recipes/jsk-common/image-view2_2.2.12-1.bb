# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A simple viewer for ROS image topics with draw-on features"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://ros.org/wiki/image_view2"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_common"
ROS_BPN = "image_view2"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    image-geometry \
    image-transport \
    image-view \
    message-filters \
    message-generation \
    pcl-ros \
    roscpp \
    rostest \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    image-geometry \
    image-transport \
    image-view \
    message-filters \
    message-runtime \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-scipy} \
    python3-numpy \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_common-release/archive/release/noetic/image_view2/2.2.12-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/image_view2"
SRC_URI = "git://github.com/tork-a/jsk_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "c7038ff4e917476d9f44f5521cf6d6a83f6e7c41"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
