# Copyright 2019-2023 NXP

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

CXXFLAGS += " -Wno-error=deprecated -Wno-error=deprecated-declarations"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Add-scan_frame_id-to-match-output-frame-id-of-depthi.patch"