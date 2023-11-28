# Copyright 2019-2023 NXP
# Copyright (c) 2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    ament-cmake-gtest \
    cppzmq \
    gtest \
"

FILES:${PN}-dev += "${libdir}/BehaviorTreeV3/cmake"
