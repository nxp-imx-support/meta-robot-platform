# Copyright 2019-2023 NXP

ROS_BUILD_DEPENDS:remove = " \
    ament-cmake-auto \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    eigen3-cmake-module-native \
    ${PYTHON_PN}-numpy-native \
"