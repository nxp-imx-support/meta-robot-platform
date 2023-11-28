# Copyright 2019-2023 NXP

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

CXXFLAGS += " -Wno-error=deprecated -Wno-error=deprecated-declarations"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"