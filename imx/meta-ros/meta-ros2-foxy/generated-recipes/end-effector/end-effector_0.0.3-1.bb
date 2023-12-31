# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "End-Effector2 package: provides a ROS2-based set of standard interfaces to command robotics end-effectors in an agnostic fashion"
AUTHOR = "Luca Muratore <luca.muratore@iit.it>"
ROS_AUTHOR = "Davide Torielli"
HOMEPAGE = "https://advrhumanoids.github.io/ROSEndEffectorDocs/"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=5a034bfdd80f2941632b4629d4fe2295"

ROS_CN = "end_effector"
ROS_BPN = "end_effector"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-muparser} \
    kdl-parser \
    moveit-ros-planning-interface \
    pluginlib \
    rclcpp \
    rclcpp-action \
    rclpy \
    rosee-msg \
    srdfdom \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-muparser} \
    kdl-parser \
    moveit-ros-planning-interface \
    pluginlib \
    rclcpp \
    rclcpp-action \
    rclpy \
    rosee-msg \
    srdfdom \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-muparser} \
    joint-state-publisher \
    joint-state-publisher-gui \
    kdl-parser \
    moveit-ros-planning-interface \
    pluginlib \
    rclcpp \
    rclcpp-action \
    rclpy \
    rosee-msg \
    srdfdom \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ADVRHumanoids/ROSEndEffector2-release/archive/release/foxy/end_effector/0.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/end_effector"
SRC_URI = "git://github.com/ADVRHumanoids/ROSEndEffector2-release;${ROS_BRANCH};protocol=https"
SRCREV = "83b0cb985177593da62486f20f142cbe578a8656"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
