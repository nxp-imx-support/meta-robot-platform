# Copyright 2019-2023 NXP

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

CXXFLAGS += " -Wno-error=sign-conversion -Wno-error=shadow -Wno-error=old-style-cast"