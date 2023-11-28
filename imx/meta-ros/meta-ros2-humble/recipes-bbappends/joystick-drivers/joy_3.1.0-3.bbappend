# Copyright (c) 2020-2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter \
    ${PYTHON_PN}-numpy-native \
    libsdl2 \
"
ROS_EXEC_DEPENDS+= " \
    libsdl2 \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-pkg-config-to-find-sdl2.patch"

inherit pkgconfig
