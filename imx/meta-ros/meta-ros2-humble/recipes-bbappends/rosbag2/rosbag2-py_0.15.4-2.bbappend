# Copyright 2019-2023 NXP

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CmakeLists.txt-Add-correct-suffix-name-for-rosbag2_p.patch"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"