# Copyright 2019-2023 NXP

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

CXXFLAGS += " -Wno-error=deprecated -Wno-error=deprecated-declarations -Wno-error=maybe-uninitialized -Wno-error=format-security"