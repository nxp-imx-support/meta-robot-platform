# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Online automated pattern-based object tracker relying on visual servoing.      visp_auto_tracker wraps model-based trackers provided by ViSP visual     servoing library into a ROS package. The tracked object should have a     QRcode, Flash code, or April tag pattern. Based on the pattern, the object is     automaticaly detected. The detection allows then to initialise the     model-based trackers. When lost of tracking achieves a new detection     is performed that will be used to re-initialize the tracker.      This computer vision algorithm computes the pose (i.e. position and     orientation) of an object in an image. It is fast enough to allow     object online tracking using a camera."
AUTHOR = "Fabien Spindler <Fabien.Spindler@inria.fr>"
ROS_AUTHOR = "Filip Novotny"
HOMEPAGE = "http://wiki.ros.org/visp_auto_tracker"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv2"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=22;endline=22;md5=fe8b75cf0aba647401e1038bcd69ee74"

ROS_CN = "vision_visp"
ROS_BPN = "visp_auto_tracker"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libdmtx-dev} \
    geometry-msgs \
    message-filters \
    resource-retriever \
    roscpp \
    sensor-msgs \
    std-msgs \
    visp \
    visp-bridge \
    visp-tracker \
    zbar \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libdmtx-dev} \
    geometry-msgs \
    message-filters \
    resource-retriever \
    roscpp \
    sensor-msgs \
    std-msgs \
    usb-cam \
    visp \
    visp-bridge \
    visp-tracker \
    zbar \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libdmtx-dev} \
    geometry-msgs \
    message-filters \
    resource-retriever \
    roscpp \
    sensor-msgs \
    std-msgs \
    usb-cam \
    visp \
    visp-bridge \
    visp-tracker \
    zbar \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/lagadic/vision_visp-release/archive/release/noetic/visp_auto_tracker/0.13.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/visp_auto_tracker"
SRC_URI = "git://github.com/lagadic/vision_visp-release;${ROS_BRANCH};protocol=https"
SRCREV = "c40c35948b48a0fc934fcfefe7d8e0e01224a080"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
