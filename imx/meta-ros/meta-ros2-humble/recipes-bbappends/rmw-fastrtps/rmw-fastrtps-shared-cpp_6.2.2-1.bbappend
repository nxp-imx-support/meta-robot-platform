# Copyright 2019-2023 NXP

ROS_BUILD_DEPENDS += " \
    rosidl-cmake \
    rosidl-default-runtime \
    rosidl-generator-cpp \
"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"