# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "mapviz"
AUTHOR = "Marc Alban <malban@swri.org>"
ROS_AUTHOR = "Marc Alban"
HOMEPAGE = "https://github.com/swri-robotics/mapviz"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mapviz"
ROS_BPN = "mapviz"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    libxi \
    libxmu \
    marti-common-msgs \
    message-generation \
    pluginlib \
    qtbase \
    rosapi \
    roscpp \
    rqt-gui \
    rqt-gui-cpp \
    std-srvs \
    swri-transform-util \
    swri-yaml-util \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    pkgconfig-native \
    qtbase-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    libxi \
    libxmu \
    marti-common-msgs \
    pluginlib \
    rosapi \
    roscpp \
    rqt-gui \
    rqt-gui-cpp \
    std-srvs \
    swri-transform-util \
    swri-yaml-util \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    libxi \
    libxmu \
    marti-common-msgs \
    message-runtime \
    pluginlib \
    qtbase \
    rosapi \
    roscpp \
    rqt-gui \
    rqt-gui-cpp \
    std-srvs \
    swri-transform-util \
    swri-yaml-util \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/swri-robotics-gbp/mapviz-release/archive/release/noetic/mapviz/1.4.2-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mapviz"
SRC_URI = "git://github.com/swri-robotics-gbp/mapviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "b08c4a13e22e141927f5b6190604831e0a4e26b0"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
