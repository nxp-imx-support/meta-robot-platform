# Copyright 2019-2023 NXP

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-drop-dependency-on-zstd_vendor.patch"

# PN package in zstd-vendor is empty and not created, remove runtime dependency on it
ROS_BUILD_DEPENDS:remove = "zstd-vendor"
ROS_EXPORT_DEPENDS:remove = "zstd-vendor"
ROS_EXEC_DEPENDS:remove = "zstd-vendor"

ROS_BUILD_DEPENDS += " \
    zstd \
"

ROS_EXEC_DEPENDS += " \
    zstd \
"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

inherit pkgconfig