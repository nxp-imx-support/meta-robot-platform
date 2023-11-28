# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "3D visualization tool for ROS."
AUTHOR = "Robert Haschke <rhaschke@techfak.uni-bielefeld.de>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "http://wiki.ros.org/rviz"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD & Creative Commons"
LICENSE = "BSD & Creative-Commons"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz"
ROS_BPN = "rviz"

ROS_BUILD_DEPENDS = " \
    assimp \
    cmake-modules \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    libeigen \
    libtinyxml2 \
    map-msgs \
    mesa \
    message-filters \
    message-generation \
    nav-msgs \
    ogre \
    pluginlib \
    python-qt-binding \
    qtbase \
    resource-retriever \
    rosconsole \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
    urdfdom \
    urdfdom-headers \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    libtinyxml2 \
    map-msgs \
    mesa \
    message-filters \
    nav-msgs \
    ogre \
    pluginlib \
    python-qt-binding \
    resource-retriever \
    rosconsole \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    libtinyxml2 \
    map-msgs \
    media-export \
    mesa \
    message-filters \
    message-runtime \
    nav-msgs \
    ogre \
    pluginlib \
    python-qt-binding \
    qtbase \
    resource-retriever \
    rosconsole \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
    visualization-msgs \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/rviz-release/archive/release/noetic/rviz/1.14.19-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rviz"
SRC_URI = "git://github.com/ros-gbp/rviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "786e2ca508d455bb10c2e86d59ab5fdf03904816"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
