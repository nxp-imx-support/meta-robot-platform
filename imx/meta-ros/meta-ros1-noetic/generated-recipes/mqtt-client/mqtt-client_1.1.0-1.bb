# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Provides a nodelet that enables connected ROS-based devices or robots to exchange ROS messages via an MQTT broker using the MQTT protocol."
AUTHOR = "Lennart Reiher <lennart.reiher@rwth-aachen.de>"
ROS_AUTHOR = "Lennart Reiher <lennart.reiher@rwth-aachen.de>"
HOMEPAGE = "http://wiki.ros.org/mqtt_client"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "mqtt_client"
ROS_BPN = "mqtt_client"

ROS_BUILD_DEPENDS = " \
    message-generation \
    nodelet \
    paho-mqtt-cpp \
    roscpp \
    std-msgs \
    topic-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-generation \
    nodelet \
    paho-mqtt-cpp \
    roscpp \
    std-msgs \
    topic-tools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-generation \
    message-runtime \
    nodelet \
    paho-mqtt-cpp \
    roscpp \
    std-msgs \
    topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ika-rwth-aachen/mqtt_client-release/archive/release/noetic/mqtt_client/1.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mqtt_client"
SRC_URI = "git://github.com/ika-rwth-aachen/mqtt_client-release;${ROS_BRANCH};protocol=https"
SRCREV = "df04a0602cde47ce88bc468494b04775059c7a6b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
