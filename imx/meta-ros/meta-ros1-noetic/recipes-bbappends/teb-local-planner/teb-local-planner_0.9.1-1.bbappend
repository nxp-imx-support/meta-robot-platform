# Copyright 2019-2023 NXP

ROS_BUILD_DEPENDS += " \
    suitesparse \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-the-compile-issue-which-undefined-reference-to-i.patch"