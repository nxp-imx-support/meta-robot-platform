# Copyright 2019-2023 NXP

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-remove-fmt-version.patch \
"

ROS_BUILDTOOL_DEPENDS += " \
    eigen3-cmake-module-native \
"

INSANE_SKIP:${PN} += "installed-vs-shipped"